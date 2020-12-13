package com.example.testproject.injectionmanager

interface IHasComponent {
    fun getComponent(): Any
    fun getComponentKey(): String = javaClass.toString()
}