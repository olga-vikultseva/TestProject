package com.example.testproject.dashboardfeature.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testproject.R
import com.example.testproject.app.TestApplication
import com.example.testproject.dashboardfeature.di.DashboardFeatureComponent
import com.example.testproject.dashboardfeature.domain.DashboardInteractor
import com.example.testproject.injectionmanager.IHasComponent
import com.example.testproject.injectionmanager.InjectionManager
import kotlinx.android.synthetic.main.fragment_dashboard.*
import javax.inject.Inject

class DashboardFragment : Fragment(), IHasComponent {

    @Inject
    lateinit var dashboardInteractor: DashboardInteractor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        InjectionManager.bindComponent<DashboardFeatureComponent>(this).inject(this)
        bindUI()
    }

    override fun getComponent(): DashboardFeatureComponent =
        TestApplication.appComponent.dashboardFeatureComponentFactory().create()

    private fun bindUI() {

        dashboardInteractor.value.observe(viewLifecycleOwner) {
            text_dashboard_screen.text = it.toString()
        }

        button_dashboard_screen.setOnClickListener {
            dashboardInteractor.increaseValue()
        }
    }

    companion object {
        fun newInstance() = DashboardFragment()
    }
}