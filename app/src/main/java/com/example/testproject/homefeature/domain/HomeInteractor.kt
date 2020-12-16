package com.example.testproject.homefeature.domain

import androidx.lifecycle.LiveData

interface HomeInteractor {
    val value: LiveData<Int>
    fun increaseValue()
}