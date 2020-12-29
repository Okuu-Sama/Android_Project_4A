package com.example.android_project_4a.data.repository

import android.util.Log
import com.example.android_project_4a.data.remote.GranblueApi
import com.example.android_project_4a.data.remote.models.RestGranblueResponse
import com.example.android_project_4a.domain.entity.Granblue_Character
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GranblueRepository(private val gbfApi: GranblueApi) {
    var apiresult : RestGranblueResponse? = RestGranblueResponse()
    suspend fun getCharacterList() : List<Granblue_Character>?
    {
        val result = gbfApi.getGranblueCharacter()
        apiresult = result
        return apiresult?.getResults()
    }
}