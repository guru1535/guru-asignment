package com.example.sessionmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sessionmanagement.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            // Navigate To Home Activity
            startActivity(Intent(applicationContext , HomeActivity::class.java))
        }


        binding.btnSignup.setOnClickListener {

            // Navigate To SignUp Activity
            startActivity(Intent(applicationContext , SignupActivity::class.java))
        }
    }
}