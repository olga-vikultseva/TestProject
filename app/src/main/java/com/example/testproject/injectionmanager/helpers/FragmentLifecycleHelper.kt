package com.example.testproject.injectionmanager.helpers

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.testproject.injectionmanager.ComponentsStore
import com.example.testproject.injectionmanager.IHasComponent

class FragmentLifecycleHelper(
    private val componentsStore: ComponentsStore
) : FragmentManager.FragmentLifecycleCallbacks() {

    private var isConfigurationChange = false

    override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
        super.onFragmentStarted(fm, f)
        isConfigurationChange = false
    }

    override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
        super.onFragmentResumed(fm, f)
        isConfigurationChange = false
    }

    override fun onFragmentSaveInstanceState(fm: FragmentManager, f: Fragment, outState: Bundle) {
        super.onFragmentSaveInstanceState(fm, f, outState)
        isConfigurationChange = true
    }

    override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
        super.onFragmentDestroyed(fm, f)

        if (f !is IHasComponent) return

        if (!isConfigurationChange || f.requireActivity().isFinishing) {
            componentsStore.removeComponent(f.getComponentKey())
            return
        }
    }
}