package com.example.androidassessment2022.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.androidassessment2022.Activity.LoginActivity
import com.example.androidassessment2022.Activity.Preference.PrefManager
import com.example.androidassessment2022.R
import com.example.androidassessment2022.databinding.ActivitySignupBinding
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSubmit.setOnClickListener {

            var firstName = binding.etFirstName.text.toString().trim()
            var lastName = binding.etLastName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()
            var confirmPassword = binding.etConfirmPassword.text.toString().trim()




            resetFocos()

            if (firstName.isEmpty()){
                // show error
                setError(binding.etFirstName , "Enter First Name")
            }else if (lastName.isEmpty()){
                // show error
                setError(binding.etLastName , "Enter Last Name")
            }else if (!isValidEmail(email)){
                // show error
                setError(binding.etEmail , "Enter Valid Email Address")
            }else if (!isValidPassword(password)){
                // show error
                setError(binding.etPassword , "Enter Valid Password")
            }else if (password != confirmPassword){
                // show error
                setError(binding.etConfirmPassword , "Enter Matched Password")
                binding.etConfirmPassword.setText("")

            }else{
                signup(firstName  , lastName , email , password  , confirmPassword)

            }



        }
    }

    private fun signup(firstName: String, lastName: String, email: String, password: String, confirmPassword: String) {

        var manager = PrefManager(this)
        manager.saveUserDetail(firstName , lastName , email , password , confirmPassword)
        manager.saveLoginDetail(email,password)
        startActivity(Intent(applicationContext , LoginActivity::class.java))
        Toast.makeText(applicationContext, "Account Created Successfully", Toast.LENGTH_SHORT).show()
        finish()
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

        binding.etFirstName.setBackgroundResource(R.drawable.background_edittext)
        binding.etLastName.setBackgroundResource(R.drawable.background_edittext)
        binding.etEmail.setBackgroundResource(R.drawable.background_edittext)
        binding.etPassword.setBackgroundResource(R.drawable.background_edittext)
        binding.etConfirmPassword.setBackgroundResource(R.drawable.background_edittext)


    }
}