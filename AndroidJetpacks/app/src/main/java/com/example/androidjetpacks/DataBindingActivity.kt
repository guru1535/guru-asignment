package com.example.androidjetpacks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.androidjetpacks.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    val tvName  :TextView
    get() = findViewById(R.id.tv_name)


    val tvEmail  :TextView
    get() = findViewById(R.id.tv_email)

    lateinit var binding: ActivityDataBindingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this ,R.layout.activity_data_binding )




         binding.person = Person("Keval" , "keval@gmail.com ")

       // tvName.text = "Keval"
        //tvEmail.text = "keval@gmail.com"


        findViewById<Button>(R.id.btn_update).setOnClickListener {

           binding.person = Person("Ram" , "ram@gmail.com")


        }
    }
}