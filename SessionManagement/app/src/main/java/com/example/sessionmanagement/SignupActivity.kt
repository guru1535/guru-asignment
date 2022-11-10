package com.example.sessionmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sessionmanagement.Preference.PrefManager
import com.example.sessionmanagement.databinding.ActivitySignupBinding
import com.example.sessionmanagement.databinding.ActivitySplashBinding

class SignupActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {


            var firstName = binding.etFname.text.toString().trim()
            var lastName = binding.etLname.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var contact = binding.etContact.text.toString().trim()
            var password = binding.etPassword.toString().trim()
            var confirmPassword = binding.etCpassword.toString().trim()

            signup(firstName ,lastName , email , contact , password , confirmPassword)
        }


    }

    private fun signup(firstName: String, lastName: String, email: String, contact: String, password: String, confirmPassword: String) {

        var manager = PrefManager(this)
        manager.saveUserDetail(firstName , lastName, email, contact, password, confirmPassword)
        manager.setLoginStatus(true)

        Toast.makeText(applicationContext, "Account Created Successfully.", Toast.LENGTH_SHORT).show()
        startActivity(Intent(applicationContext , HomeActivity::class.java))
    }
}