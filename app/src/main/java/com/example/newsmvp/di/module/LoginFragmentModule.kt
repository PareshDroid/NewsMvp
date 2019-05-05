package com.example.newsmvp.di.module

import com.example.newsmvp.features.authentication.fragment.LoginContract
import com.example.newsmvp.features.authentication.fragment.LoginPresenter
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides

@Module
class LoginFragmentModule {

    @Provides
    fun provideFirebaseInstance(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideLoginPresenter():LoginContract.Presenter{
        return LoginPresenter()
    }

}