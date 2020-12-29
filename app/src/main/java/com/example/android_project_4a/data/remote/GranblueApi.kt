package com.example.android_project_4a.data.remote

import kotlinx.coroutines.Deferred
import com.example.android_project_4a.data.remote.models.RestGranblueResponse
import com.example.android_project_4a.domain.entity.Granblue_Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface GranblueApi {
    @GET("GranblueFantasyapi.json")
    suspend fun getGranblueCharacter(): RestGranblueResponse?
}