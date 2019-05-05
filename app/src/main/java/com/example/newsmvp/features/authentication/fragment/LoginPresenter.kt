package com.example.newsmvp.features.authentication.fragment

import com.google.firebase.auth.FirebaseAuth

class LoginPresenter:LoginContract.Presenter{

    private lateinit var view: LoginContract.View


    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: LoginContract.View) {
        this.view = view
    }

    override fun onLoginClicked(email: String, pwd: String) {

        view.showDialog()
        FirebaseAuth.getInstance().signInWithEmailAndPassword("paresh@pk.com", "paresh123")
            .addOnCompleteListener(view.passActivity()) { task ->
                if (task.isSuccessful) {

                    view.onLoginSuccess()
                    view.dismissDialog()
                } else {

                    view.onLoginFailure()
                    view.dismissDialog()
                }

            }
    }

}