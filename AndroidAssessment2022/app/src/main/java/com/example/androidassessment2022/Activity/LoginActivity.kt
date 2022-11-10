package com.example.androidassessment2022.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.androidassessment2022.Activity.Preference.PrefManager
import com.example.androidassessment2022.R
import com.example.androidassessment2022.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var manager:PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


         manager = PrefManager(this)
        if (manager.getLoginStatus()){
            startActivity(Intent(this,DashBoardActivity::class.java))
        }



        binding.btnLogin.setOnClickListener {

            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()



            resetFocos()

            if (!isValidEmail(email)){
                // show error
                setError(binding.etEmail , "Enter Valid Email Address")
            }else if (!isValidPassword(password)){
                // show error
                setError(binding.etPassword , "Enter Valid Password")
            }else{
                login(email , password)
            }



        }

        binding.btnSignup.setOnClickListener {
            // navigate to signup activity
            startActivity(Intent(applicationContext , SignupActivity::class.java))
        }
    }

    private fun login(email: String, password: String) {

        val saveEmail = manager.getLoginEmail()
        val savePass = manager.getPass()

        Log.e("TAG", "login:$saveEmail ", )
        Log.e("TAG", "login:$savePass ", )

        if(saveEmail != email && savePass != password) {


            Toast.makeText(applicationContext, "Invalid Email or Password", Toast.LENGTH_SHORT).show()
        } else{


            manager.setLoginStatus(true)
            manager.saveLoginDetail(email, password)
            startActivity(Intent(applicationContext, DashBoardActivity::class.java))
            finishAffinity()
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {

        var regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
        return Pattern.compile(regex).matcher(password).matches()
    }

    private fun setError(editText: EditText? = null, error: String) {

        editText?.let {

            it.setBackgroundResource(R.drawable.bg_error_edittext)
            it.requestFocus()
        }


        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()
    }

    private fun resetFocos() {


        binding.etEmail.setBackgroundResource(R.drawable.background_edittext)
        binding.etPassword.setBackgroundResource(R.drawable.background_edittext)



    }
}