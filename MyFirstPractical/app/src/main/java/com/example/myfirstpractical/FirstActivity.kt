package com.example.myfirstpractical

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class FirstActivity : AppCompatActivity() {

        lateinit var btnSubmit  : Button
        lateinit var etName  : EditText
        lateinit var etEmail : EditText
        lateinit var etAge : EditText





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        btnSubmit = findViewById(R.id.btn_submit)
        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        etAge = findViewById(R.id.et_age)

        println("Activity Created")

        // Button click event

        btnSubmit.setOnClickListener {

            var name = etName.text.toString().trim()
            var email = etEmail.text.toString().trim()
            var age = etAge.text.toString().trim()

            Log.d("FIELDS", "name = $name email = $email age =  $age")


         /*   var intent = Intent(applicationContext, SecondActivity::class.java)

            intent.putExtra("NAME", name)
            intent.putExtra("EMAIL", email)
            intent.putExtra("AGE", if (age.isEmpty()) "0" else "age")

            startActivity(intent)*/

            var user = User(name , email , age.toInt())

            var intent = Intent(applicationContext , SecondActivity::class.java)

            intent.putExtra("USER" , user)

            startActivity(intent)
        }
    }
}