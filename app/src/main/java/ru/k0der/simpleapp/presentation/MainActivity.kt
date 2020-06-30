package ru.k0der.simpleapp.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import ru.k0der.simpleapp.App
import ru.k0der.simpleapp.BuildConfig
import ru.k0der.simpleapp.R
import ru.k0der.simpleapp.data.response.CreateResponse
import ru.k0der.simpleapp.data.response.PointResponse
import ru.k0der.simpleapp.domain.MainIntercator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainIntercator: MainIntercator

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainSendButton.setOnClickListener {
            val token: String? = getSharedPreferences(
                BuildConfig.TOKEN,
                Context.MODE_PRIVATE
            ).getString(BuildConfig.TOKEN, null)

            CoroutineScope(Dispatchers.IO).launch {
                token?.let {
                    val result = mainIntercator.locationsCreate(
                        token = "Bearer $it",
                        points = listOf(
                            CreateResponse(
                                point = PointResponse(
                                    lat = 55.32562,
                                    lng = 88.36863
                                ),
                                sent = "2018-06-07 06:38",
                                trip_id = 2101015,
                                type = 1,
                                speed = 60
                            )
                        )
                    )

                    Log.d("token", it)

                    withContext(MainScope().coroutineContext) {
                        var str = if (result?.result!!) {
                            "Все хорошо"
                        } else {
                            "Сервер не принял"
                        }
                        str = str + "\n\nОтвет сервера:\n"
                        Toast.makeText(
                            this@MainActivity,
                            str+result.toString(),
                            Toast.LENGTH_LONG+2+str.length
                        ).show()
                    }

                }
            }

        }
    }
}