package com.example.android_project_4a.data.repository

import com.example.android_project_4a.data.remote.GranblueApi
import com.example.android_project_4a.domain.entity.Granblue_Character

class GranblueRepository(private val gbfApi: GranblueApi)
{

    suspend fun getCharacterList() : List<Granblue_Character>?
    {
        val result = gbfApi.getGranblueCharacter()
        return result?.getResults()
    }
}