package com.example.android_project_4a.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android_project_4a.data.local.models.UserLocal

@Database(entities = [UserLocal::class], version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun databaseDao(): DatabaseDao
}