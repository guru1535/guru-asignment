package com.example.myprojectui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.myprojectui.R
import com.example.myprojectui.databinding.ActivityForgatePasswordBinding
import java.time.Instant
import java.util.regex.Pattern

class ForgatePasswordActivity : AppCompatActivity() {

    lateinit var binding: ActivityForgatePasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgatePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNewPassword.setOnClickListener {

            var email = binding.etREmail.text.toString().trim()
            var newPassword = binding.etNPassword.text.toString().trim()
            var confirmNewPassword = binding.etNcPassword.text.toString().trim()

            resetFocus()

            if (!isValidrEmail(email)){

                // show error
                setError(binding.etREmail , "Enter valid Email")
            }else if (!isValidnPassword(newPassword)){

                // show error
                setError(binding.etNPassword , "Enter valid Email")
            }else if (newPassword != confirmNewPassword){

                // show error
                setError(binding.etNcPassword , "Enter valid Email")

            }else {

                Toast.makeText(applicationContext, "okk", Toast.LENGTH_SHORT)
                    .show()
            }





        }
    }

    private fun isValidrEmail(email : String) : Boolean
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidnPassword(password :String) : Boolean
    {
        var regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
        return  Pattern.compile(regex).matcher(password).matches()
    }

    private fun setError(editText: EditText, error: String)
    {
        editText.setBackgroundResource(R.drawable.app_background_error_edittext)
        editText.requestFocus()
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()

    }

    private fun resetFocus() {
        binding.etREmail.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etNPassword.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etNcPassword.setBackgroundResource(R.drawable.app_background_edittext)





    }
}