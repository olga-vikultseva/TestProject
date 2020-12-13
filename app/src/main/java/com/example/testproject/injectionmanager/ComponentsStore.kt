package com.example.testproject.injectionmanager

import com.example.testproject.injectionmanager.exceptions.ComponentNotFoundException

class ComponentsStore {

    private val componentsMap = mutableMapOf<String, Any>()

    fun isComponentExist(key: String): Boolean = componentsMap.containsKey(key)

    fun addComponent(key: String, component: Any) {
        componentsMap[key] = component
    }

    fun getComponent(key: String): Any = componentsMap[key] ?: throw ComponentNotFoundException()

    fun removeComponent(key: String) {
        componentsMap.remove(key)
    }

    fun findComponent(predicate: (Any) -> Boolean): Any {
        for ((_, component) in componentsMap) {
            if (predicate(component)) return component
        }
        throw ComponentNotFoundException()
    }
}