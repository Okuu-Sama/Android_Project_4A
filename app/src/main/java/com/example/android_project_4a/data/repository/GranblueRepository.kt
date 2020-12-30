package com.example.android_project_4a.data.repository

import com.example.android_project_4a.data.remote.GranblueApi
import com.example.android_project_4a.domain.entity.Granblue_Character

class GranblueRepository(private val gbfApi: GranblueApi)
{
    //Function to get convert the response from the remote server here an object containing a list
    //into a the proper list of object
    suspend fun getCharacterList() : List<Granblue_Character>?
    {
        val result = gbfApi.getGranblueCharacter()
        return result?.getResults()
    }
}