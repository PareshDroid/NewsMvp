package com.example.newsmvp.features.authentication.activity

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.newsmvp.R
import com.example.newsmvp.di.component.DaggerAuthenticationactivityComponent
import com.example.newsmvp.di.module.AuthenticationActivityModule
import com.example.newsmvp.features.authentication.fragment.LoginFragment
import com.example.newsmvp.features.authentication.fragment.RegistrationFragment
import javax.inject.Inject

class AuthenticationActivity: AppCompatActivity(),
    AuthenticationContract.View,
    AuthenticationContract.FragmentCommunication {


    @Inject
    lateinit var presenter: AuthenticationContract.Presenter

    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        injectDependency()

        presenter.attach(this)

    }

    override fun showLoginFragment() {
        fragmentManager=supportFragmentManager
        fragmentManager
            .beginTransaction()
            .add(
                R.id.frame_login,
                LoginFragment().newInstance(),
                LoginFragment.TAG
            )
            .commit()
    }

    override fun showRegistrationFragment() {
        Log.d("show","show")
    }

    private fun injectDependency() {
        val activityComponent = DaggerAuthenticationactivityComponent.builder()
            .authenticationActivityModule(AuthenticationActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun openRegistrationFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.frame_login, RegistrationFragment().newInstance(),
                RegistrationFragment.TAG
            )
            .addToBackStack(null)
            .commit()

    }
}
