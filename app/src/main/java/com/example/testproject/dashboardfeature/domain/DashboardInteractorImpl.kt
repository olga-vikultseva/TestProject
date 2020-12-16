package com.example.testproject.dashboardfeature.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DashboardInteractorImpl : DashboardInteractor {

    private val _value = MutableLiveData<Int>(0)
    override val value: LiveData<Int>
        get() = _value

    override fun increaseValue() {
        val currentValue = _value.value!!
        _value.value = currentValue + 1
    }
}