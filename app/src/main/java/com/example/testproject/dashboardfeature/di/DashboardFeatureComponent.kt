package com.example.testproject.dashboardfeature.di

import com.example.testproject.dashboardfeature.ui.DashboardFragment
import dagger.Subcomponent

@DashboardFeatureScope
@Subcomponent(modules = [DashboardFeatureModule::class])
interface DashboardFeatureComponent {

    fun inject(fragment: DashboardFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): DashboardFeatureComponent
    }
}