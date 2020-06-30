package ru.k0der.simpleapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.k0der.simpleapp.presentation.AuthorizationActivity
import ru.k0der.simpleapp.presentation.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun inject(activity: AuthorizationActivity)
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): AppComponent
    }

    companion object {
        fun locationsCreate(context: Context): AppComponent =
            with(DaggerAppComponent.builder()) {
                setContext(context)
                build()
            }
    }
}