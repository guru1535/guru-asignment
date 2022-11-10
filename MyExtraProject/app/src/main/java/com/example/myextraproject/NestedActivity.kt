package com.example.myextraproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlin.math.log


class NestedActivity : AppCompatActivity() {




    lateinit var btnSubmit1 : Button
    lateinit var etEmail1 : EditText
    lateinit var etPassword : EditText
    lateinit var btnSignup : Button
    lateinit var etFirstname : EditText
    lateinit var etSecondname : EditText
    lateinit var etLastname : EditText
    lateinit var btnForpassword : Button
    lateinit var etNewpassword : EditText
    lateinit var etConfirmpassword : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested)

        btnSubmit1 = findViewById(R.id.btn_submit1)
        etEmail1 = findViewById(R.id.et_email1)
        etPassword = findViewById(R.id.et_password)
        btnSignup = findViewById(R.id.btn_signup)
        etFirstname = findViewById(R.id.et_firstname)
        etSecondname = findViewById(R.id.et_secondname)
        etLastname = findViewById(R.id.et_lastname)
        btnForpassword = findViewById(R.id.btn_forpassword)
        etNewpassword = findViewById(R.id.et_newpassword)
        etConfirmpassword = findViewById(R.id.et_confirmpassword)


        btnSubmit1.setOnClickListener {

            var email1 = etEmail1.text.toString().trim()
            var password = etPassword.text.toString().trim()

            Log.d("FIRST" , "EMAIL1 : $email1   PASSWORD : $password")


            var userf = Userf(email1 , password  )
            var intent = Intent(applicationContext , LoginActivity::class.java)

            intent.putExtra("USERF" , userf)

            startActivity(intent)
        }


        btnSignup.setOnClickListener {

            var firstname = etFirstname.text.toString().trim()
            var secondname = etSecondname.text.toString().trim()
            var lastname = etLastname.text.toString().toString()


            Log.d("SECOND" , " FIRSTNAME : $firstname    SECONDNAME : $secondname  LASTNAME : $lastname ")

            var user2 = User2(firstname , secondname , lastname)
            var intent = Intent(applicationContext , SignUpActivity::class.java)

            intent.putExtra("USER2"  , user2)

            startActivity(intent)
        }



        btnForpassword.setOnClickListener {

            var newpassword = etNewpassword.text.toString().trim()
            var confirmpassword = etConfirmpassword.text.toString().trim()


            Log.d("THIRD" , " NEWPASSWORD  : $newpassword   CONFIRMPASSWORD  : $confirmpassword ")


            var user3 = User3(newpassword , confirmpassword)
            var intent = Intent(applicationContext , ForgatePasswordActivity::class.java)
            intent.putExtra("USER3" , user3)

            startActivity(intent)
        }
    }
}