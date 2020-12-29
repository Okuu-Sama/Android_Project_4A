package com.example.android_project_4a.presentation.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_project_4a.domain.entity.User
import com.example.android_project_4a.domain.usecase.CreateUserUseCase
import com.example.android_project_4a.domain.usecase.VerifyUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignupViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val verifyUserUseCase: VerifyUserUseCase
) : ViewModel()
{

    val signupLiveData: MutableLiveData<SignupStatus> = MutableLiveData()

    fun onClickedSignup(emailUser: String, password: String)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val exist =  verifyUserUseCase.invoke(emailUser)
            val signupStatus = if(!exist)
            {
                val newUser = User(emailUser,password)
                createUserUseCase.invoke(newUser)
                SignupSuccess(newUser)

            }else
            {
                SignupError
            }

            withContext(Dispatchers.Main)
            {
                signupLiveData.value = signupStatus
            }
        }
    }

}