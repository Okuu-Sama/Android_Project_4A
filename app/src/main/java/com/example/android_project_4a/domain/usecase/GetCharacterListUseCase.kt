package com.example.android_project_4a.domain.usecase

import com.example.android_project_4a.data.repository.GranblueRepository
import com.example.android_project_4a.domain.entity.Granblue_Character

class GetCharacterListUseCase(
    private val granblueRepository: GranblueRepository
) {
    suspend fun invoke() : List<Granblue_Character>? {
        return granblueRepository.getCharacterList()
    }
}