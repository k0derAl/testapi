package ru.k0der.simpleapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_authorization.*
import kotlinx.coroutines.*
import ru.k0der.simpleapp.App
import ru.k0der.simpleapp.BuildConfig
import ru.k0der.simpleapp.R
import ru.k0der.simpleapp.data.response.BaseResponse
import ru.k0der.simpleapp.data.response.BodyAuth
import ru.k0der.simpleapp.data.response.DeviceInfo
import ru.k0der.simpleapp.domain.MainIntercator
import java.lang.Exception
import javax.inject.Inject

class AuthorizationActivity : AppCompatActivity() {

    @Inject
    lateinit var mainIntercator: MainIntercator

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        val token: String? = getSharedPreferences(
            BuildConfig.TOKEN,
            Context.MODE_PRIVATE
        ).getString(BuildConfig.TOKEN, null)
        if (token != null) {
            startActivity(Intent(this, MainActivity::class.java))
        }

        authLoginButton.setOnClickListener {
            val login = authLoginEditText.text.toString()
            val password = authPasswordEditText.text.toString()

            progressBar.visibility = View.VISIBLE

            CoroutineScope(Dispatchers.IO).launch {
                if (login.isNotEmpty() and password.isNotEmpty()) {
                    val result = mainIntercator.auth(
                        BodyAuth(
                            login = login,
                            password = password,
                            deviceInfo = DeviceInfo(os = "android", hardwareId = 2, appVersion = 1)
                        )
                    )
                    if (result?.result?.token != null) {
                        getSharedPreferences(
                            BuildConfig.TOKEN,
                            Context.MODE_PRIVATE
                        ).edit {
                            putString(BuildConfig.TOKEN, result.result.token)
                        }
                        startActivity(Intent(this@AuthorizationActivity, MainActivity::class.java))
                    } else {

                        withContext(MainScope().coroutineContext) {
                            Toast.makeText(
                                this@AuthorizationActivity,
                                "Ошибка авторизации ",
                                Toast.LENGTH_LONG
                            ).show()
                            progressBar.visibility = View.GONE
                        }

                    }

                }
            }
        }
    }
}