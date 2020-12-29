package com.example.android_project_4a.domain.usecase

import com.example.android_project_4a.data.repository.UserRepository

class VerifyUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(email: String) : Boolean
    {
        return userRepository.verifyUser(email)
    }
}