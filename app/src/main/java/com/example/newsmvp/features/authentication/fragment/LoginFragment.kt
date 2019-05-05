package com.example.newsmvp.features.authentication.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.example.newsmvp.MainActivity
import com.example.newsmvp.R
import com.example.newsmvp.di.component.DaggerLoginFragmentComponent
import com.example.newsmvp.di.module.LoginFragmentModule
import com.example.newsmvp.features.authentication.activity.AuthenticationActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment: Fragment(),LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    private lateinit var rootView: View

    fun newInstance(): LoginFragment {
        return LoginFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.fragment_login, container, false)
        return rootView
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter.attach(this)

        button_login.setOnClickListener {
           presenter.onLoginClicked("paresh@pk.com", "paresh123")
        }

        button_register.setOnClickListener {
            (activity as AuthenticationActivity).openRegistrationFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    private fun injectDependency() {
        val aboutComponent = DaggerLoginFragmentComponent.builder()
            .loginFragmentModule(LoginFragmentModule())
            .build()

        aboutComponent.inject(this)
    }

    override fun onLoginSuccess() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }

    override fun onLoginFailure() {
        Toast.makeText(activity,"Sorry login id or pwd do not match",Toast.LENGTH_SHORT).show()
    }


    override fun passActivity():Activity {
        return activity as AuthenticationActivity
    }

    override fun showDialog() {
        progressBar.visibility = View.VISIBLE
    }

    override fun dismissDialog() {
        progressBar.visibility = View.INVISIBLE
    }


    companion object {
        val TAG: String = "LoginFragment"
    }
}