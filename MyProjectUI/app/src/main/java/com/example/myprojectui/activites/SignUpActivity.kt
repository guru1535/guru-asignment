package com.example.myprojectui.activites

import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myprojectui.R
import com.example.myprojectui.databinding.ActivitySignUpBinding
import java.lang.Error
import java.util.regex.Pattern
import android.widget.Toast.makeText as makeText1


class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnsignup.setOnClickListener {

            var firstName = binding.etFirstname.text.toString().trim()
            var lastName = binding.etLastname.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var mobailNumber = binding.etMobailno.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()
            var confirmPassword = binding.etCpassword.text.toString().trim()


            resetFocus()

            if (firstName.isEmpty()) {
                //show error
               // binding.etFirstname.error = "Enter First Name"
                setError(binding.etFirstname , "Enter First Name")
            } else if (lastName.isEmpty()) {
                // show error
                //  binding.etLastname.error = "Enter Last Name"
                setError(binding.etLastname , "Enter Second Name")
            } else if (!isValidEmail(email)) {

                // show error
                // binding.etEmail.error = "Enter Valid Email "
                setError(binding.etEmail , "Enter valid Email")
            } else if (!isValidMobailNumber(mobailNumber)) {
                // show error
               // binding.etMobailno.error = "Enter Valid Mobail Number"
                setError(binding.etMobailno , "Enter Valid Mobail Number")
            } else if (!isValidPassword(password)) {
                // show error
                //  binding.etPassword.error = "Enter Valid Password"
                setError(binding.etPassword , "Enter Valid Password")
            } else if (password != confirmPassword) {
                // show error
              //  binding.etCpassword.error = "Don't matched Password"
                setError(binding.etCpassword , "Password Mitchmatched")
                binding.etCpassword.setText("")
            } else {
            // All Fields are valid
                Toast.makeText(applicationContext, "All fields are validated", Toast.LENGTH_SHORT)
                    .show()


                }
            }



    }

    private fun isValidEmail(email : String) : Boolean
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidMobailNumber(mobailNumber: String) : Boolean
    {
        return mobailNumber.length == 10

    }

    private fun isValidPassword(password :String) : Boolean
    {
        var regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
        return  Pattern.compile(regex).matcher(password).matches()
    }

    private fun setError(editText: EditText , error: String)
    {
        editText.setBackgroundResource(R.drawable.app_background_error_edittext)
        editText.requestFocus()
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()

    }

    private fun resetFocus()
    {
        binding.etFirstname.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etLastname.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etEmail.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etMobailno.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etPassword.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etCpassword.setBackgroundResource(R.drawable.app_background_edittext)

    }


}




