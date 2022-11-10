package com.example.myroomdatabase.Database.Dao

import androidx.room.*
import com.example.myroomdatabase.Database.Entity.User

@Dao
interface UserDAO {

    @Insert
    fun insertRecord(user: User)

    @Delete
    fun deleteRecord(user: User)

    @Update
    fun updateRecord(user: User)

    @Query("select * from user_table")
    fun getAllRecord():List<User>

    @Query("select * from user_table where id = :uid")
    fun getUser(uid:Int):User
}