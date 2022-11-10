package com.example.myroomdatabase.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myroomdatabase.Database.Dao.UserDAO
import com.example.myroomdatabase.Database.Entity.User


@Database(entities = [User::class] , version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun UserDao():UserDAO
}