package com.example.newsmvp.features.authentication.fragment

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.newsmvp.R
import com.example.newsmvp.di.component.DaggerLoginFragmentComponent
import com.example.newsmvp.di.component.DaggerRegistrationFragmentComponent
import com.example.newsmvp.di.module.LoginFragmentModule
import com.example.newsmvp.di.module.RegistrationFragmentModule
import com.example.newsmvp.features.authentication.activity.AuthenticationActivity
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_registration.*
import javax.inject.Inject

class RegistrationFragment: Fragment(),RegistrationContract.View {

    private lateinit var rootView: View

    @Inject
    lateinit var presenter: RegistrationContract.Presenter

    fun newInstance(): RegistrationFragment {
        return RegistrationFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.fragment_registration, container, false)
        return rootView
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter.attach(this)

        button_sign_up.setOnClickListener {
            presenter.onRegistrationClicked("pares@pk.com", "paresh123")
        }
    }

    companion object {
        val TAG: String = "RegistrationFragment"
    }

    private fun injectDependency() {
        val aboutComponent = DaggerRegistrationFragmentComponent.builder()
            .registrationFragmentModule(RegistrationFragmentModule())
            .build()

        aboutComponent.inject(this)
    }

    override fun onRegistrationSuccess() {
        activity?.supportFragmentManager?.popBackStack()
    }

    override fun onRegistrationFailure() {
        Toast.makeText(activity,"Sorry registration failed", Toast.LENGTH_SHORT).show()
    }

    override fun passActivity(): Activity {
        return activity as AuthenticationActivity
    }

    override fun showDialog() {
        progressBar_registration.visibility = View.VISIBLE
    }

    override fun dismissDialog() {
        progressBar_registration.visibility = View.INVISIBLE
    }

}