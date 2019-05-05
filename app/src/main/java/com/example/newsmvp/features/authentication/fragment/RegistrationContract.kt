package com.example.newsmvp.features.authentication.fragment

import android.app.Activity
import com.example.newsmvp.features.base.BaseContract

class RegistrationContract {
    interface View: BaseContract.View {
        fun onRegistrationSuccess()
        fun onRegistrationFailure()
        fun passActivity(): Activity
        fun showDialog()
        fun dismissDialog()
    }



    interface Presenter: BaseContract.Presenter<RegistrationContract.View> {
        fun onRegistrationClicked(email:String,pwd:String)

    }
}