package com.example.testproject.dashboardfeature.domain

import androidx.lifecycle.LiveData

interface DashboardInteractor {
    val value: LiveData<Int>
    fun increaseValue()
}