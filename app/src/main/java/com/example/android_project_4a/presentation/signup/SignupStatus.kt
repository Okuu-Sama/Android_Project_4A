package com.example.android_project_4a.presentation.signup

import com.example.android_project_4a.domain.entity.User

sealed class SignupStatus

data class SignupSuccess(val user: User) : SignupStatus()
object SignupError : SignupStatus()