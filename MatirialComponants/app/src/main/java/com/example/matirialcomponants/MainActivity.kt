package com.example.matirialcomponants

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    val autoCountry : AutoCompleteTextView
    get() = findViewById(R.id.auto_country)

    var countries = arrayOf("India" , "Russia" ,"Japan" , "Germany" , "Bhutan" , "Nepal" , "Maldives")

    lateinit var adapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this , android.R.layout.simple_spinner_item , countries)
        autoCountry.setAdapter(adapter)


        findViewById<Button>(R.id.btn_click_me).setOnClickListener {

            showAlertDialog()
        }

    }

    private fun showAlertDialog() {

        MaterialAlertDialogBuilder(this)
            .setTitle("Alert")
            .setMessage("Alert Dialog")
            .setPositiveButton("Done" , DialogInterface.OnClickListener { dialogInterface, i ->


            } ).show()
    }
}