package com.example.newsmvp.di.component

import com.example.newsmvp.di.module.AuthenticationActivityModule
import com.example.newsmvp.features.authentication.activity.AuthenticationActivity
import dagger.Component

@Component(modules = arrayOf(AuthenticationActivityModule::class))
interface AuthenticationactivityComponent {
    fun inject(authenticationActivity: AuthenticationActivity)
}