package com.example.testproject.injectionmanager

import android.app.Application
import com.example.testproject.injectionmanager.helper.ActivityLifecycleHelper

class InjectionManager {

    companion object {                                 // если это фабричный метод, почему мы не передаем сюда app: Application
        @JvmStatic                                     // тогда функцию init можно было бы заменить на блок init
        val instance = InjectionManager()
    }

    private val componentsStore = ComponentsStore()

    fun init(app: Application) {
        app.registerActivityLifecycleCallbacks(ActivityLifecycleHelper(componentsStore))
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