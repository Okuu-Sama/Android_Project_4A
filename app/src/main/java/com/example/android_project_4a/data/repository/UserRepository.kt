package com.example.android_project_4a.data.repository

import com.example.android_project_4a.data.local.DatabaseDao
import com.example.android_project_4a.data.local.models.toData
import com.example.android_project_4a.data.local.models.toEntity
import com.example.android_project_4a.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
){

    //Calling this function will insert the specified user in the database
    fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    //We verify the if the given data exist in the DB
    fun verifyUser(email: String) : Boolean
    {
        val userLocal = databaseDao.findByName(email)
        if (userLocal != null)
        {
            return true
        }
        return false
    }

    //We fetch a certain user from the DB
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