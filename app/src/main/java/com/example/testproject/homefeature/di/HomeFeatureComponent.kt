package com.example.testproject.homefeature.di

import com.example.testproject.homefeature.ui.HomeFragment
import dagger.Subcomponent

@HomeFeatureScope
@Subcomponent(modules = [HomeFeatureModule::class])
interface HomeFeatureComponent {

    fun inject(fragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeFeatureComponent
    }
}