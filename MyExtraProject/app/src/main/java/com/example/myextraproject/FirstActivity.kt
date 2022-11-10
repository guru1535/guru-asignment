package com.example.myextraproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class FirstActivity : AppCompatActivity() {


    lateinit var btnSubmit : Button
    lateinit var etName : EditText
    lateinit var etEmail : EditText
    lateinit var etAge : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)


        btnSubmit = findViewById(R.id.btn_submit)
        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        etAge = findViewById(R.id.et_age)


        btnSubmit.setOnClickListener {

            var name = etName.text.toString().toString().trim()
            var email = etEmail.text.toString().toString().trim()
            var age = etAge.text.toString().toString().trim()


            Log.d("FEILED" , "NAME : $name  EMAIL : $email   AGE : $age")


            var user = User(name , email , age.toInt())
            var intent = Intent (applicationContext , SecondActivity::class.java)
            intent.putExtra("USER" , user)
            startActivity(intent)
        }



    }
}