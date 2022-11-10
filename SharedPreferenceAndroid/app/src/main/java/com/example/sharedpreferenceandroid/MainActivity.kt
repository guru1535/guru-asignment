package com.example.sharedpreferenceandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferenceandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var name: String = ""
    var email :String = ""
    var age : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSave.setOnClickListener {

            name = binding.etName.text.toString().trim()
            email = binding.etEmail.text.toString().trim()
            age = binding.etAge.text.toString().trim().toInt()


            saveRecord(name , email , age)
        }

        binding.btnRead.setOnClickListener {

            readRecord()
        }


    }

    private fun readRecord() {

        var preference = getSharedPreferences("Keval-Students" , MODE_PRIVATE)
        var name = preference.getString("NAME" , "Not Updated")
        var email = preference.getString("EMAIL" , "Not Updated")
        var age = preference.getInt("AGE" , 0)



        binding.tvResult.text = """
            
            name : $name
            email : $email
            age : $age
            
        """.trimIndent()
    }

    private fun saveRecord(name :String , email :String , age :Int) {

        var preference = getSharedPreferences("Keval-Students" , MODE_PRIVATE)
        var editor = preference.edit()
        editor.putString("NAME" , name)
        editor.putString("EMAIL" , email)
        editor.putInt("AGE" , age)
        editor.commit()

        Toast.makeText(applicationContext, "Data Saved Successfully", Toast.LENGTH_SHORT).show()


    }
}