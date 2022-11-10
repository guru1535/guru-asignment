package com.example.roomdatabaseandroid.DataBase.DAO

import androidx.room.*
import com.example.roomdatabaseandroid.DataBase.Entity.User

@Dao
interface UserDAO {

    @Insert
    fun userInsertRecord(user: User)

    @Delete
    fun deleteRecord(user: User)

    @Update
    fun updateRecord(user: User)

    @Query("select * from user_table")
    fun getAllRecord() : List<User>

    @Query("select * from user_table where id = :uid")
    fun getUser(uid : Int) : User

}