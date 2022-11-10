package com.example.androidadapterji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.AutoText
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.androidadapterji.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var language = arrayOf("Java" , "Kotlin" , "Dart" , "Python" , "Swift" , "Java Script")
    private var countries = arrayOf("India" , "Russia" , "Bhutan" , "Japan" , "Germany" , "Nepal" )
    private var states = arrayOf("Gujarat" , "Maharastra" , "Panjab" , "UP" , "MP" ,"Bihar")
    private var cities = arrayOf("Surat" , "Bhavnagar" , "Amreli" , "Rajkot" , "Jamnagar" , "Junagadh")
    private lateinit var mAdapter : ArrayAdapter<String>
    private lateinit var mSpinner : ArrayAdapter<String>
    private lateinit var mGrid : ArrayAdapter<String>
    private lateinit var mAutoText: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // List View

        mAdapter = ArrayAdapter(this , android.R.layout.simple_list_item_1 , language)
        binding.listView.adapter = mAdapter
        binding.listView.setOnItemClickListener { adapterView, view, position, l ->


            var lang = language[position]
            Toast.makeText(applicationContext , "$lang" , Toast.LENGTH_SHORT).show()
        }


        // Spinner

        mSpinner = ArrayAdapter(this , android.R.layout.simple_spinner_item , countries)
        binding.spinner.adapter = mSpinner
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {

                var country = countries[pos]
                Toast.makeText(applicationContext , "$country" , Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        // Grid View

        mGrid = ArrayAdapter(this , android.R.layout.simple_list_item_1 , states)
        binding.gridView.adapter = mGrid
        binding.gridView.setOnItemClickListener { adapterView, view, pos, l ->

            var state = states[pos]
            Toast.makeText(applicationContext , "$state" , Toast.LENGTH_SHORT).show()
        }

        // AutoCompleteTextView

        mAutoText = ArrayAdapter(this , android.R.layout.simple_spinner_item , cities)
        binding.textView.setAdapter(mAutoText)
        binding.listView.setOnItemClickListener { adapterView, view, pos, l ->


            var city = adapterView.getItemAtPosition(pos)
            Toast.makeText(applicationContext , "$city" , Toast.LENGTH_SHORT).show()
        }



    }
}