package com.example.kevalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.kevalproject.Preference.PrefManager
import com.example.kevalproject.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {

        }

        binding.btnLogin.setOnClickListener {

            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()



            resetFocous()

            if (!isValidEmail(email)){

                setError(binding.etEmail , "Enter Valid Email")

            }else if (!isValidPassword(password)){

                setError(binding.etPassword , "Enter Valid Password")

            }else{

                login(email , password)
            }

        }
    }

    private fun login(email: String, password: String) {

        var manager = PrefManager(this)
        manager.saveUserDetail(email , password)
        manager.setLoginStatus(true)

        startActivity(Intent(applicationContext , HomeActivity::class.java))
        finish()

    }

    private fun resetFocous() {
        binding.etEmail.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etPassword.setBackgroundResource(R.drawable.app_bg_edit_text)

    }

    private fun setError(editText: EditText, error: String){

        editText.setBackgroundResource(R.drawable.app_bg_error_edit_text)
        editText.requestFocus()
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()

    }

    private fun isValidPassword(password: String): Boolean{
        var regex =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
        return Pattern.compile(regex).matcher(password).matches()

    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}