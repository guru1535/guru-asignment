package com.example.roomdatabaseandroid.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabaseandroid.DataBase.DAO.UserDAO
import com.example.roomdatabaseandroid.DataBase.Entity.User


@Database(entities = [User::class] , version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun UserDao() : UserDAO
}