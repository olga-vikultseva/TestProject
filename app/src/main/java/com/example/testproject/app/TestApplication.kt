package com.example.testproject.app

import android.app.Application
import com.example.testproject.app.di.AppComponent
import com.example.testproject.app.di.DaggerAppComponent
import com.example.testproject.injectionmanager.IHasComponent
import com.example.testproject.injectionmanager.InjectionManager

class TestApplication : Application(), IHasComponent {

    override fun onCreate() {
        super.onCreate()
        InjectionManager.init(this)
        InjectionManager.bindComponent<AppComponent>(this)
    }

    override fun getComponent(): AppComponent {
        return DaggerAppComponent.factory().create().also {
            appComponent = it
        }
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}