package com.example.testproject.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testproject.R
import com.example.testproject.dashboardfeature.DashboardFragment
import com.example.testproject.homefeature.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            openFragment(HomeFragment.newInstance())
        }

        nav_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    openFragment(HomeFragment.newInstance())
                    true
                }
                R.id.navigation_dashboard -> {
                    openFragment(DashboardFragment.newInstance())
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root_container, fragment)
            .commit()
    }

}

//        supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
//
//            override fun onFragmentAttached(fm: FragmentManager, f: Fragment, context: Context) {
//                super.onFragmentAttached(fm, f, context)
//                Log.d("test", "onFragmentAttached - ${f.javaClass}")
//            }
//
//            override fun onFragmentCreated(
//                fm: FragmentManager,
//                f: Fragment,
//                savedInstanceState: Bundle?
//            ) {
//                super.onFragmentCreated(fm, f, savedInstanceState)
//                Log.d("test", "onFragmentCreated - ${f.javaClass}")
//            }
//
//            override fun onFragmentViewCreated(
//                fm: FragmentManager,
//                f: Fragment,
//                v: View,
//                savedInstanceState: Bundle?
//            ) {
//                super.onFragmentViewCreated(fm, f, v, savedInstanceState)
//                Log.d("test", "onFragmentViewCreated - ${f.javaClass}")
//            }
//
//            override fun onFragmentActivityCreated(
//                fm: FragmentManager,
//                f: Fragment,
//                savedInstanceState: Bundle?
//            ) {
//                super.onFragmentActivityCreated(fm, f, savedInstanceState)
//                Log.d("test", "onFragmentActivityCreated - ${f.javaClass}")
//            }
//
//            override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
//                super.onFragmentStarted(fm, f)
//                Log.d("test", "onFragmentStarted - ${f.javaClass}")
//            }
//
//            override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
//                super.onFragmentResumed(fm, f)
//                Log.d("test", "onFragmentResumed - ${f.javaClass}")
//            }
//
//            override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
//                super.onFragmentPaused(fm, f)
//                Log.d("test", "onFragmentPaused - ${f.javaClass}")
//            }
//
//            override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
//                super.onFragmentStopped(fm, f)
//                Log.d("test", "onFragmentStopped - ${f.javaClass}")
//            }
//
//            override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
//                super.onFragmentViewDestroyed(fm, f)
//                Log.d("test", "onFragmentViewDestroyed - ${f.javaClass}")
//            }
//
//            override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
//                super.onFragmentDestroyed(fm, f)
//                Log.d("test", "onFragmentDestroyed - ${f.javaClass}")
//            }
//
//            override fun onFragmentDetached(fm: FragmentManager, f: Fragment) {
//                super.onFragmentDetached(fm, f)
//                Log.d("test", "onFragmentDetached - ${f.javaClass}")
//            }
//        },true)
