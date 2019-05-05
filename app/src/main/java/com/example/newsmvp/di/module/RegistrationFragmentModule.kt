package com.example.newsmvp.di.module

import com.example.newsmvp.features.authentication.fragment.LoginContract
import com.example.newsmvp.features.authentication.fragment.LoginPresenter
import com.example.newsmvp.features.authentication.fragment.RegistrationContract
import com.example.newsmvp.features.authentication.fragment.RegistrationPresenter
import dagger.Module
import dagger.Provides

@Module
class RegistrationFragmentModule {

    @Provides
    fun provideLoginPresenter(): RegistrationContract.Presenter{
        return RegistrationPresenter()
    }
}