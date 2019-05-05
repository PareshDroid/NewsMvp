package com.example.newsmvp.features.authentication.fragment

import android.app.Activity
import com.example.newsmvp.features.base.BaseContract

class LoginContract {

    interface View: BaseContract.View {
        fun onLoginSuccess()
        fun onLoginFailure()
        fun passActivity(): Activity
        fun showDialog()
        fun dismissDialog()
    }

    interface Presenter: BaseContract.Presenter<LoginContract.View> {
        fun onLoginClicked(email:String,pwd:String)

    }
}