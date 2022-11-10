package com.example.myextraproject

import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {


    val tvLogin : TextView
    get() = findViewById(R.id.tv_login)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    var userf = intent.getParcelableExtra<Userf>("USERF")





    }


