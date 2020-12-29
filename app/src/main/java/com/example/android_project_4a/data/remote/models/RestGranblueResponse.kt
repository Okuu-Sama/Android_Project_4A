package com.example.android_project_4a.data.remote.models

import com.example.android_project_4a.domain.entity.Granblue_Character

class RestGranblueResponse {
    private val results: List<Granblue_Character>? = null
    fun getResults() : List<Granblue_Character>? { return results}
}