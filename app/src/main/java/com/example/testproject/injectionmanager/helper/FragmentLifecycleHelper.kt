package com.example.testproject.injectionmanager.helper

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.testproject.injectionmanager.ComponentsStore
import com.example.testproject.injectionmanager.IHasComponent

class FragmentLifecycleHelper(
    private val componentsStore: ComponentsStore
) : FragmentManager.FragmentLifecycleCallbacks() {

    private var isInSaveState = false

    override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
        super.onFragmentStarted(fm, f)
        isInSaveState = false
    }

    override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
        super.onFragmentResumed(fm, f)
        isInSaveState = false
    }

    override fun onFragmentSaveInstanceState(fm: FragmentManager, f: Fragment, outState: Bundle) {
        super.onFragmentSaveInstanceState(fm, f, outState)
        isInSaveState = true
    }

    override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
        super.onFragmentDestroyed(fm, f)

        if (f !is IHasComponent) return

        if (f.requireActivity().isFinishing) {
            componentsStore.removeComponent(f.javaClass.toString())
            return
        }

        if (isInSaveState) {
            isInSaveState = false
            return
        }

        var anyParentIsRemoving = false
        var parent = f.parentFragment
        while (!anyParentIsRemoving && parent != null) {
            anyParentIsRemoving = parent.isRemoving
            parent = parent.parentFragment
        }
        if (f.isRemoving || anyParentIsRemoving) {
            componentsStore.removeComponent(f.getComponentKey())
        }
    }
}