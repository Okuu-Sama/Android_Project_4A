package com.example.android_project_4a.presentation.signup

import com.example.android_project_4a.domain.entity.User

//Sealed class to process the status of the user's sign up
sealed class SignupStatus

data class SignupSuccess(val user: User) : SignupStatus()
object SignupError : SignupStatus()