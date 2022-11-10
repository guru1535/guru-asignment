package com.example.firstuiformvalidation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.firstuiformvalidation.R
import com.example.firstuiformvalidation.databinding.ActivitySignUpBinding
import java.lang.Error
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding
    private var gender = ""
    private var isChecked = false
    private var isDarkMode = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ckeck box event

        binding.chkTerms.setOnCheckedChangeListener { compoundButton, checked ->

            isChecked = checked
        }

        // switch

        binding.swtMode.setOnCheckedChangeListener { compoundButton, checked ->

            isDarkMode = checked
        }


        binding.btnSignup.setOnClickListener {

            var firstName = binding.etFirstname.text.toString().trim()
            var lastName = binding.etLastname.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var mobailNumber = binding.etMobailnumber.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()
            var confirmPassword = binding.etConfirmpassword.text.toString().trim()


            resetFocos()

            if (firstName.isEmpty()) {
                // show error
                //binding.etFirstname.error = "Enter First Name"
                setError(binding.etFirstname, "Enter First Name")
            } else if (lastName.isEmpty()) {
                // show error
                //binding.etLastname.error = " Enter Last Name"
                setError(binding.etLastname, "Enter Last Name")
            } else if (!isValidEmail(email)) {
                //show error
                // binding.etEmail.error = "Enter Valid Email Addres"bin
                setError(binding.etEmail, "Enter valid Email")
            } else if (!isValidMobailNumber(mobailNumber)) {
                //show error
                // binding.etMobailnumber.error = "Enter Valid Mobail Number "
                setError(binding.etMobailnumber, "Enter valid Mobail Number")

            } else if (gender.isEmpty()){

                setError(error = "Select Gender")
            } else if (!isValidPassword(password)) {
                //show error
                // binding.etPassword.error = "Enter Valid Password"
                setError(binding.etPassword, "Enter Valid Password")
            } else if (password != confirmPassword) {
                // show error
                // binding.etConfirmpassword.error = "MitchMatched Password"
                setError(binding.etConfirmpassword, "Mitchmatched Password")
                binding.etConfirmpassword.setText("")
            } else if (!isChecked){
                setError(error = "Please Checked terms and condition")

            } else {
                // all fields are valid

                Toast.makeText(applicationContext, "all fields are valid", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidMobailNumber(mobailNumber: String): Boolean {
        return mobailNumber.length == 10
    }

    private fun isValidPassword(password: String): Boolean {

        var regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
        return Pattern.compile(regex).matcher(password).matches()
    }

    private fun setError(editText: EditText? = null , error: String) {

        editText?.let {

           it.setBackgroundResource(R.drawable.app_background_error_edittext)
           it.requestFocus()
        }


        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()
    }

    private fun resetFocos() {

        binding.etFirstname.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etLastname.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etEmail.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etMobailnumber.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etPassword.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etConfirmpassword.setBackgroundResource(R.drawable.app_background_edittext)

    }

    fun onRadioButtonClicked(view: View) {

      gender =  when(view.id){

            R.id.rb_male -> "Male"
            R.id.rb_female -> "Female"
            R.id.rb_other -> "Other"
          else -> " "
      }
    }

}