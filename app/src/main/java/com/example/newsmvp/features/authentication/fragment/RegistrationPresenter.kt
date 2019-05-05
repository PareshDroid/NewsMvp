package com.example.newsmvp.features.authentication.fragment

import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegistrationPresenter:RegistrationContract.Presenter {

    private lateinit var view: RegistrationContract.View


    override fun onRegistrationClicked(email: String, pwd: String) {
        view.showDialog()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pwd)
            .addOnCompleteListener(view.passActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    view.dismissDialog()
                    view.onRegistrationSuccess()
                } else {
                    // If sign in fails, display a message to the user.
                    view.dismissDialog()
                    view.onRegistrationFailure()
                }
            }
    }

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: RegistrationContract.View) {
       this.view = view
    }
}