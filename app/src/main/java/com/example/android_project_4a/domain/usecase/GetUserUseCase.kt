package com.example.android_project_4a.domain.usecase

import com.example.android_project_4a.data.repository.UserRepository
import com.example.android_project_4a.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User{
        return userRepository.getUser(email)
    }
}