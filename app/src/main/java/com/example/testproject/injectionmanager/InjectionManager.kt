package com.example.testproject.injectionmanager

import android.app.Application
import com.example.testproject.injectionmanager.helpers.ActivityLifecycleHelper

object InjectionManager {

    private val componentsStore = ComponentsStore()

    fun init(application: Application) {
        application.registerActivityLifecycleCallbacks(ActivityLifecycleHelper(componentsStore))
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> bindComponent(owner: IHasComponent): T =
        getComponentOrCreate(owner.getComponentKey(), owner) as T

    inline fun <reified T> findComponent(): T =
        findComponent { it is T } as T

    fun findComponent(predicate: (Any) -> Boolean): Any =
        componentsStore.findComponent(predicate)

    private fun getComponentOrCreate(key: String, owner: IHasComponent): Any {
        return if (componentsStore.isComponentExist(key)) {
            componentsStore.getComponent(key)
        } else {
            owner.getComponent().also { component ->
                componentsStore.addComponent(key, component)
            }
        }
    }

}