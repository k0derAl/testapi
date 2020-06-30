package ru.k0der.simpleapp

import android.app.Application
import ru.k0der.simpleapp.di.AppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.locationsCreate(this)
    }
}