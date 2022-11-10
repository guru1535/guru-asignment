package com.example.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.EditText

class FirstActivity : AppCompatActivity() {

    lateinit var btnsubmit : Button
    lateinit var etName : EditText
    lateinit var etEmailId : EditText
    lateinit var etAge : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        btnsubmit = findViewById(R.id.btn_submit)
        etName = findViewById(R.id.et_name)
        etEmailId = findViewById(R.id.et_emailid)
        etAge = findViewById(R.id.et_age)

        println("Activity Created")

        // click event of button

        btnsubmit.setOnClickListener {


            var name = etName.text.toString().trim()
            var email = etEmailId.text.toString().trim()
            var age = etAge.text.toString().trim()

            Log.d("FIELDS" , "name = $name email = $email  age = $age")



            // one activity mathi biji activiti ma event transfer karva mate  nichina statement no use thay che
            // apde button click karvathi first Activity mathi Second Activity ma java mate
            // Navigate from first activities to another Activities


          /*  var intent = Intent(applicationContext ,SecondActivity::class.java)

            intent.putExtra("NAME" , name)
            intent.putExtra("EMAIL" , email)
            intent.putExtra("AGE" ,if (age.isEmpty()) "0" else age)
            startActivity(intent) */


            var user = User(name , email , age.toInt())

            var intent = Intent(applicationContext , SecondActivity::class.java)

            intent.putExtra("USER" , user)

            startActivity(intent)
        }
    }
}