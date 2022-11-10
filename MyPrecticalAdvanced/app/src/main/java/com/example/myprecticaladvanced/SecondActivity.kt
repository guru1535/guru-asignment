package com.example.myprecticaladvanced

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

  val tvName : TextView
  get() = findViewById(R.id.tv_name)

  val tvEmail : TextView
  get() = findViewById(R.id.tv_email)

  val tvAge : TextView
  get() = findViewById(R.id.tv_age)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



        var user = intent.getParcelableExtra<User>("USER")

        user?.let {

            tvName.text = "NAME : ${it.name}"
            tvEmail.text = "EMAIL : ${it.email}"
            tvAge.text = "Age : ${it.age}"
        }



    }
}