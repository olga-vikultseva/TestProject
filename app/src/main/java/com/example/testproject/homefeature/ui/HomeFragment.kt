package com.example.testproject.homefeature.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testproject.R
import com.example.testproject.app.TestApplication
import com.example.testproject.homefeature.di.HomeFeatureComponent
import com.example.testproject.homefeature.domain.HomeInteractor
import com.example.testproject.injectionmanager.IHasComponent
import com.example.testproject.injectionmanager.InjectionManager
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment(), IHasComponent {

    @Inject
    lateinit var homeInteractor: HomeInteractor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        InjectionManager.bindComponent<HomeFeatureComponent>(this).inject(this)
        bindUI()
    }

    override fun getComponent(): HomeFeatureComponent =
        TestApplication.appComponent.homeFeatureComponentFactory().create()

    private fun bindUI() {

        homeInteractor.value.observe(viewLifecycleOwner) {
            text_home_screen.text = it.toString()
        }

        button_home_screen.setOnClickListener {
            homeInteractor.increaseValue()
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}