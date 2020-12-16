package com.example.testproject.dashboardfeature.di

import com.example.testproject.dashboardfeature.domain.DashboardInteractor
import com.example.testproject.dashboardfeature.domain.DashboardInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class DashboardFeatureModule {
    @DashboardFeatureScope
    @Provides
    fun provideDashboardInteractor(): DashboardInteractor = DashboardInteractorImpl()
}