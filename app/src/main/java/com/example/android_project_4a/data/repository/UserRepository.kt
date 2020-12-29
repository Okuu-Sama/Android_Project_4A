package com.example.android_project_4a.data.repository

import com.example.android_project_4a.data.local.DatabaseDao
import com.example.android_project_4a.data.local.models.toData
import com.example.android_project_4a.data.local.models.toEntity
import com.example.android_project_4a.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
){

    fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun verifyUser(email: String) : Boolean
    {
        val userLocal = databaseDao.findByName(email)
        if (userLocal != null)
        {
            return true
        }
        return false
    }

    fun getUser(email: String, password: String) : User?
    {
        val userLocal = databaseDao.findByName(email)
        if(userLocal?.password.equals(password))
        {
            return userLocal?.toEntity()
        }
        return null
    }
}