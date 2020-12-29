package com.example.android_project_4a.data.remote

import com.example.android_project_4a.data.remote.models.RestGranblueResponse
import retrofit2.http.GET

interface GranblueApi
{
    @GET("GranblueFantasyapi.json")
    suspend fun getGranblueCharacter(): RestGranblueResponse?
}