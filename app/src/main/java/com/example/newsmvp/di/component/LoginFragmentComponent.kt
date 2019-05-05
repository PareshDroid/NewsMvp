package com.example.newsmvp.di.component

import com.example.newsmvp.di.module.LoginFragmentModule
import com.example.newsmvp.features.authentication.fragment.LoginFragment
import dagger.Component

@Component(modules = arrayOf(LoginFragmentModule::class))
interface LoginFragmentComponent {
    fun inject(loginFragment: LoginFragment)
}