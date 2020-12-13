package com.example.testproject.app.di

import com.example.testproject.app.TestApplication
import com.example.testproject.core.di.AppDependency
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : AppDependency {          // interface AppComponent наследуясь от interface AppDependency
                                                  // должен предоставить в одном из своих модулей метод, который будет
                                                  // возвращать объект типа TextHolder?
    fun inject(testApplication: TestApplication)

    class Initializer private constructor() {              // Отличается ли такой подход от interface Factory c fun create()?
        companion object {
            fun init(): AppComponent = DaggerAppComponent.builder().build()
        }
    }
}