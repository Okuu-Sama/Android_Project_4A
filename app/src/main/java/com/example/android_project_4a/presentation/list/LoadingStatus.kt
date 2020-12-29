package com.example.android_project_4a.presentation.list

import com.example.android_project_4a.domain.entity.Granblue_Character

sealed class LoadingStatus

data class LoadingSuccess(val characterList: List<Granblue_Character>) : LoadingStatus()
object LoadingError : LoadingStatus()