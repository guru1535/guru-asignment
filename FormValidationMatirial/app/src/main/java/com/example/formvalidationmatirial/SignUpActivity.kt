package com.example.formvalidationmatirial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.formvalidationmatirial.databinding.ActivitySignUpBinding
import java.lang.Error
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    
    lateinit var binding: ActivitySignUpBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        
        
        binding.btnSubmit.setOnClickListener { 
            
            var firstname = binding.etFname.text.toString().trim()
            var lastname = binding.etLname.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var contact = binding.etContact.text.toString().trim()
            var password = binding.etPassword.toString().trim()
            var confirmpassword = binding.etCpassword.toString().trim()
            
            resetFocous()
            
            if (firstname.isEmpty()){
                
                setError(binding.etFname , "Enter First Name")
            }else if (lastname.isEmpty()){
                
                setError(binding.etLname , "Enter Last Name")
            }else if (!isValidEmail(email)){
                setError(binding.etEmail , "Enter Valid Email Address")
            }else if (!isValidContact(contact)){
                setError(binding.etContact , "Enter Valid Contact")
            }else if (!isValidPassword(password)){
                setError(binding.etPassword , "Enter Valid Password")
            }else if (password != confirmpassword){
                setError(binding.etPassword , "Mismatched Your Password")
                binding.etCpassword.setText("")
            }else{

                Toast.makeText(applicationContext, "All Filed Are Valid", Toast.LENGTH_SHORT).show()
            }
            
        }
        
        
    }
    private fun isValidEmail(email :String) : Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        
    }
    private fun isValidContact(contact : String):Boolean{
        return contact.length == 10
    }
    
    private fun isValidPassword(password : String):Boolean{

        var regex =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
        return Pattern.compile(regex).matcher(password).matches()
    }
    
    private fun setError(editText: EditText , error: String){
        
        editText.setBackgroundResource(R.drawable.app_bg_error_edit_text)
        editText.requestFocus()
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()
        
    }
    
    private fun resetFocous(){
        
        binding.etFname.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etLname.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etEmail.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etContact.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etPassword.setBackgroundResource(R.drawable.app_bg_edit_text)
        binding.etCpassword.setBackgroundResource(R.drawable.app_bg_edit_text)
        
    }
}