package com.example.android_project_4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_project_4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel()
{

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    //After the user click on the login button we process his entered data
    //If his credential is valid we notify the main activity with a successful login status
    //otherwise the error status is returned
    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser, password)
            val loginStatus = if(user != null){
                LoginSuccess(user.email)
            }else{
                LoginError
            }

            withContext(Dispatchers.Main)
            {
                loginLiveData.value = loginStatus
            }
        }
    }

}