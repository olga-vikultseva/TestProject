package com.example.testproject.core.di

import com.example.testproject.core.TextHolder

interface AppDependency {
    fun provideSingletonTextHolder(): TextHolder
}