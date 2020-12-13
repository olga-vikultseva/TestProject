package com.example.testproject.app.di

import com.example.testproject.core.TextHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideTextHolder(): TextHolder = TextHolder()
}