package com.example.testproject.injectionmanager

import android.util.Log
import com.example.testproject.injectionmanager.exceptions.ComponentNotFoundException

class ComponentsStore {

    private val componentsMap = mutableMapOf<String, Any>()

    fun isComponentExist(key: String): Boolean = componentsMap.containsKey(key)

    fun addComponent(key: String, component: Any) {
        Log.d("test", "В ComponentStore добавлен новый компонент: component - ${component.javaClass}, key - $key")
        componentsMap[key] = component
    }

    fun getComponent(key: String): Any = componentsMap[key] ?: throw ComponentNotFoundException()

    fun removeComponent(key: String) {
        Log.d("test", "Из ComponentStore удален компонент: key - $key")
        componentsMap.remove(key)
    }

    fun findComponent(predicate: (Any) -> Boolean): Any {
        for ((_, component) in componentsMap) {
            if (predicate(component)) return component
        }
        throw ComponentNotFoundException()
    }
}