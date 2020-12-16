package com.example.testproject.injectionmanager.helpers

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.injectionmanager.ComponentsStore
import com.example.testproject.injectionmanager.IHasComponent

class ActivityLifecycleHelper(
    private val componentsStore: ComponentsStore
) : Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        if (activity is AppCompatActivity) {
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                FragmentLifecycleHelper(componentsStore),
                true
            )
        }
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, savedInstanceState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        if(activity is IHasComponent && activity.isFinishing) {
            componentsStore.removeComponent(activity.getComponentKey())
        }
    }
}