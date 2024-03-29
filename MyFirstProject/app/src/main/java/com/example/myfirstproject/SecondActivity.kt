package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    val tvName:TextView
    get() = findViewById(R.id.tv_name)

    val tvEmail:TextView
    get() = findViewById(R.id.tv_email)

    val tvAge:TextView
    get() = findViewById(R.id.tv_age)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        var user = intent.getParcelableExtra<User>("USER")


       /* var name = intent.getStringExtra("NAME")
        var email = intent.getStringExtra("EMAIL")
        var age = intent.getIntExtra("AGe" ,0) */


        /* tvName.text = "NAME : $name"
        tvEmail.text = "EMAIL : $email"
        tvAge.text = "AGE : $age"*/

        user?.let {

            tvName.text = "NAME : ${it.name}"
            tvEmail.text = "EMAIL : ${it.email}"
            tvAge.text = "AGE : ${it.age}"

        }
    }
}