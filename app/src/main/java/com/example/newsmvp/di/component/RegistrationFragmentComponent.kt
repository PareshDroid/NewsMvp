package com.example.newsmvp.di.component

import com.example.newsmvp.di.module.LoginFragmentModule
import com.example.newsmvp.di.module.RegistrationFragmentModule
import com.example.newsmvp.features.authentication.fragment.LoginFragment
import com.example.newsmvp.features.authentication.fragment.RegistrationFragment
import dagger.Component

@Component(modules = arrayOf(RegistrationFragmentModule::class))
interface RegistrationFragmentComponent {
    fun inject(registrationFragment: RegistrationFragment)
}