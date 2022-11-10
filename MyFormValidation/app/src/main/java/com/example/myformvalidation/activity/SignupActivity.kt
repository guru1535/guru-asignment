package com.example.myformvalidation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.myformvalidation.R
import com.example.myformvalidation.databinding.ActivitySignupBinding
import java.lang.Error
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnsignup.setOnClickListener {

            var firstname = binding.etFirstname.text.toString().trim()
            var lastname = binding.etLastname.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var mobailnumber = binding.etMobailno.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()
            var confirmpassword = binding.etCpassword.text.toString().trim()

            resetFocos()


            if (firstname.isEmpty()){
                // show error
                //binding.etFirstname.error = "Enter First name"
                setError(binding.etFirstname , "ENTER First NAME")
            }else if (lastname.isEmpty()){
                // show error
                //binding.etLastname.error = "Enter Last name"
                setError(binding.etLastname , "Enter Last Name")
            }else if (!isValidEmail(email)){
                // show error.
               // binding.etEmail.error = "Enter Valid Email"
                setError(binding.etEmail , "Enter valid email id")
            }else if (!isValidMobailNumber(mobailnumber)){
                // show error
               // binding.etMobailno.error = "Enter Valid Mobail Number"
                setError(binding.etMobailno , "Enter valid mobil number")
            }else if (!isValidPassword(password)){
                // show error
               // binding.etPassword.error = "Enter Valid Password"
                setError(binding.etPassword , "Enter Valid Password")
            }else if (password != confirmpassword){
                // show error
               // binding.etCpassword.error = "Password is missmatched"
                setError(binding.etCpassword , " Password mitchmatched")
                binding.etCpassword.setText("")
            }else {

                // All fields are valid

                Toast.makeText(applicationContext , "ALL FIELDES ARE VALID" , Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidEmail(email : String) : Boolean{

        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidMobailNumber(mobailnumber : String): Boolean{

        return mobailnumber.length == 10
    }

    private fun isValidPassword(password : String) : Boolean{

        var regex =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"

        return Pattern.compile(regex).matcher(password).matches()
    }

    private fun setError(editText: EditText , error: String) {
        editText.setBackgroundResource(R.drawable.app_bg_error_edit_text)
        editText.requestFocus()
        Toast.makeText(applicationContext , error , Toast.LENGTH_SHORT).show()
    }

    private fun resetFocos(){

        binding.etFirstname.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etLastname.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etEmail.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etMobailno.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etPassword.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etCpassword.setBackgroundResource(R.drawable.app_bg_edit_text)

    }
}