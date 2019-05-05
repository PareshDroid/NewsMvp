package com.example.newsmvp.features.authentication.activity

import com.example.newsmvp.features.authentication.activity.AuthenticationContract

class AuthenticationPresenter: AuthenticationContract.Presenter {

    private lateinit var view: AuthenticationContract.View

    override fun subscribe() {
        //
    }

    override fun unsubscribe() {
        //
    }

    override fun attach(view: AuthenticationContract.View) {
        this.view = view
        view.showLoginFragment()
    }

    override fun onRegisterClick() {
        view.showRegistrationFragment()
    }
}