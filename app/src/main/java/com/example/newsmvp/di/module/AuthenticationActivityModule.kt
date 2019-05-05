package com.example.newsmvp.di.module

import android.app.Activity
import com.example.newsmvp.features.authentication.activity.AuthenticationContract
import com.example.newsmvp.features.authentication.activity.AuthenticationPresenter
import dagger.Module
import dagger.Provides

@Module
class AuthenticationActivityModule(private var activity: Activity) {
    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): AuthenticationContract.Presenter {
        return AuthenticationPresenter()
    }

}