package com.example.firstuiformvalidation.activity

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.firstuiformvalidation.R
import com.example.firstuiformvalidation.databinding.ActivityLoginBinding
import java.lang.Error
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var dialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSignup.setOnClickListener {

            var intent = Intent(this , SignUpActivity::class.java)
            startActivity(intent)

        }

        dialog = ProgressDialog(this).apply {

            setTitle("Please wait..")
            setMessage("Please Wait")
            setCancelable(false)
        }



    // progressbar
        binding.btnLogin.setOnClickListener {

            dialog.show()

            Thread(Runnable {

                Thread.sleep(3000)

                runOnUiThread {
                    if (dialog.isShowing)
                        dialog.dismiss()


                    Toast.makeText(applicationContext, "Navigate to home page", Toast.LENGTH_SHORT)
                        .show()

                }
            }).start()
        }

        binding.btnLogin.setOnClickListener {

            var email = binding.etLoginEmail.text.toString().trim()
            var password = binding.etLoginPassword.text.toString().trim()

            resetFocos()

            if (!isValidLoginEmail(email)){
                //error
                setError(binding.etLoginEmail , "Enter Valid Email Addres")

            }else if (!isValidLoginPassword(password)){
                //error
                setError(binding.etLoginPassword , "Enter Valid Password")
            }else{

                // All are Valid

                Toast.makeText(applicationContext , "all are valid" , Toast.LENGTH_SHORT).show()
            }
        }




    }
    private fun isValidLoginEmail(email: String) : Boolean{

        return Patterns.EMAIL_ADDRESS.matcher(email).matches()

    }
    private fun isValidLoginPassword(password : String):Boolean {

        var regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"

        return Pattern.compile(regex).matcher(password).matches()

    }

    private fun setError(editText: EditText , error: String) {

        editText.setBackgroundResource(R.drawable.app_background_error_edittext)
        Toast.makeText(applicationContext , error , Toast.LENGTH_SHORT).show()
    }

    private fun resetFocos(){

        binding.etLoginEmail.setBackgroundResource(R.drawable.app_background_edittext)
        binding.etLoginPassword.setBackgroundResource(R.drawable.app_background_edittext)
    }

}





