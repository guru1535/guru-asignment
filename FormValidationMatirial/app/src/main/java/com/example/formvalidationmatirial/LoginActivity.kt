package com.example.formvalidationmatirial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.formvalidationmatirial.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {

            var intent = Intent(applicationContext , SignUpActivity::class.java)
            startActivity(intent)
        }
        
        binding.btnForgatePassword.setOnClickListener {

            Toast.makeText(applicationContext, "Forgate Password Button Clicked", Toast.LENGTH_SHORT).show()
        }
        
        binding.btnLogin.setOnClickListener { 
            
            var email = binding.etEmaillogin.text.toString().trim()
            var password = binding.etPasswordlogin.text.toString().trim()
            
            resetFocous()
            
            if (!isValidLoginEmail(email)){
                
                setError(binding.etEmaillogin , "Enter Valid Email")
                 
            }else if (!isValidLoginPassword(password)){
                
                setError(binding.etPasswordlogin , "Enter Valid Password")
                
            }else{

                Toast.makeText(applicationContext, "All Fields are Valid", Toast.LENGTH_SHORT).show()
            }
            
            
        }





    }
    private fun isValidLoginEmail(email :String) : Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()

    }
    private fun isValidLoginPassword(password : String):Boolean{

        var regex =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
        return Pattern.compile(regex).matcher(password).matches()
    }

    private fun setError(editText: EditText, error: String){

        editText.setBackgroundResource(R.drawable.app_bg_error_edit_text)
        editText.requestFocus()
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()

    }

    private fun resetFocous(){

        
       
        binding.etEmaillogin.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etPasswordlogin.setBackgroundResource(R.drawable.app_bg_edit_text)
       

    }
}