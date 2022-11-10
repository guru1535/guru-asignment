package com.example.roomdatabaseandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.roomdatabaseandroid.DataBase.AppDataBase
import com.example.roomdatabaseandroid.DataBase.Entity.User
import com.example.roomdatabaseandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var db : AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       db = Room.databaseBuilder(this , AppDataBase::class.java , "tops-user.db").allowMainThreadQueries().build()

        binding.btnSave.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()


            insertRecord(name , email)
        }
    }

    private fun insertRecord(name: String, email: String) {

        var user = User(name = name , email = email)

        db.UserDao().userInsertRecord(user)
        Toast.makeText(applicationContext, "Record Added", Toast.LENGTH_SHORT).show()

    }
}