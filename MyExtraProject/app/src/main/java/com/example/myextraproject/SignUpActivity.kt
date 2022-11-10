package com.example.myextraproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class SignUpActivity : AppCompatActivity() {

    val etFirstname : EditText
    get() = findViewById(R.id.et_firstname)

    val etSecondname :  EditText
    get() = findViewById(R.id.et_secondname)

    val etLastname :   EditText
    get() = findViewById(R.id.et_lastname)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var user2 = intent.getParcelableExtra<User2>("USER2")

        user2?.let {

            etFirstname.text = "FIRSTNAME : ${it.firstname}"
            etSecondname.text = "SECONDNAME : ${it.secondname}"
            etLastname.text = "LASTNAME : ${it.lastname}"
        }
    }
}