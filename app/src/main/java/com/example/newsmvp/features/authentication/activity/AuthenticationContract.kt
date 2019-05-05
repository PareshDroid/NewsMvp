package com.example.newsmvp.features.authentication.activity

import com.example.newsmvp.features.base.BaseContract

class AuthenticationContract {

    interface View: BaseContract.View {
        fun showLoginFragment()
        fun showRegistrationFragment()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun onRegisterClick()
    }

    interface FragmentCommunication{
        fun openRegistrationFragment()
    }
}