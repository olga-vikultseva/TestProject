package com.example.testproject.app.di

import com.example.testproject.dashboardfeature.di.DashboardFeatureComponent
import com.example.testproject.homefeature.di.HomeFeatureComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun dashboardFeatureComponentFactory(): DashboardFeatureComponent.Factory
    fun homeFeatureComponentFactory(): HomeFeatureComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }
}