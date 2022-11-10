package com.example.myprojectui.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.myprojectui.R
import com.example.myprojectui.databinding.ActivityLoginBinding
import java.lang.Error
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {

            // navigate to signup activity.

            var intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.btnForgatepassword.setOnClickListener {

            // navigate to forgate password activity

            var intent = Intent(this ,ForgatePasswordActivity::class.java)
            startActivity(intent)
        }



        binding.btnLogin.setOnClickListener {

            var email = binding.etLemail.text.toString().trim()
            var password = binding.etLpassword.text.toString().trim()


            resetFocos()

            if (!isValidlEmail(email)){

                // show Eroor

                setError(binding.etLemail , "Enter valid Email")

            }else if (!isValidlPassword(password)){

                // show Eroor
                setError(binding.etLpassword , "Enter Valid Password")

            }else{

                Toast.makeText(applicationContext, "All are Done", Toast.LENGTH_SHORT)
                    .show()



            }


        }





    }

   private fun isValidlEmail(email: String): Boolean {

        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidlPassword(password : String) : Boolean{

        var regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
        return  Pattern.compile(regex).matcher(password).matches()

    }

    private fun setError(editText: EditText , error: String){
        editText.setBackgroundResource(R.drawable.app_background_error_edittext)
        editText.requestFocus()
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()

    }
    private fun resetFocos(){

        binding.etLemail.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etLpassword.setBackgroundResource(R.drawable.app_background_edittext)
    }



}





