package com.example.testproject.homefeature.di

import com.example.testproject.homefeature.domain.HomeInteractor
import com.example.testproject.homefeature.domain.HomeInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class HomeFeatureModule {
    @HomeFeatureScope
    @Provides
    fun provideHomeInteractor(): HomeInteractor = HomeInteractorImpl()
}