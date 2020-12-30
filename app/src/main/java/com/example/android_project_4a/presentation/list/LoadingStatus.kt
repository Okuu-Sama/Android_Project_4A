package com.example.android_project_4a.presentation.list

import com.example.android_project_4a.domain.entity.Granblue_Character

//Sealed class to process the status of the loading of the character list from the API rest call
sealed class LoadingStatus

data class LoadingSuccess(val characterList: List<Granblue_Character>) : LoadingStatus()
object LoadingError : LoadingStatus()