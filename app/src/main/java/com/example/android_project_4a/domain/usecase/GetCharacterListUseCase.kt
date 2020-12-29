package com.example.android_project_4a.domain.usecase

import com.example.android_project_4a.data.remote.models.RestGranblueResponse
import com.example.android_project_4a.data.repository.GranblueRepository
import com.example.android_project_4a.data.repository.UserRepository
import com.example.android_project_4a.domain.entity.Granblue_Character
import com.example.android_project_4a.domain.entity.User
import retrofit2.Call

class GetCharacterListUseCase(
    private val granblueRepository: GranblueRepository
) {
    suspend fun invoke() : List<Granblue_Character>? {
        return granblueRepository.getCharacterList()
    }
}