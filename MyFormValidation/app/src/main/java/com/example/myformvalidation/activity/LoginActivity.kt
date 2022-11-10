package com.example.myformvalidation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.myformvalidation.R
import com.example.myformvalidation.databinding.ActivityLoginBinding
import java.lang.Error
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {

            var intent = Intent(applicationContext , SignupActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {

            var email = binding.etLemail.text.toString().trim()
            var password = binding.etLpassword.text.toString().trim()


            resetFocos()

            if (!isValidLoginEmail(email)){
                // show error
                setError(binding.etLemail , "Enter Valid Email Addres")
            }else if (!isValidLoginPassword(password)){
                // show error
                setError(binding.etLpassword , "Enter Valid Password")
                binding.etLpassword.setText("")
            }else{
                // all are valid done
                Toast.makeText(applicationContext , "All are done" , Toast.LENGTH_SHORT).show()

            }
        }





    }

    private fun  isValidLoginEmail( email : String ) : Boolean{

        return Patterns.EMAIL_ADDRESS.matcher(email).matches()


    }

    private fun isValidLoginPassword( password : String) : Boolean{

        var regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"

        return Pattern.compile(regex).matcher(password).matches()
    }

    private fun setError(editText: EditText , error: String) {
        editText.setBackgroundResource(R.drawable.app_bg_error_edit_text)
        editText.requestFocus()
        Toast.makeText(applicationContext , error , Toast.LENGTH_SHORT).show()
    }

    private fun resetFocos(){

        binding.etLemail.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etLpassword.setBackgroundResource(R.drawable.app_bg_edit_text)
    }
}