package com.example.myandroidadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myandroidadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var language = arrayOf("Kotlin" , "Java" , "Dart" , "Python" , "C" , "C++")
    private var countries = arrayOf("India"  , "Russia" , "Bhutan" , "Japan", "Germany" , "Poland" , "Brazil")
    private var states = arrayOf("Gujarat" , "Maharastra" , "Panjab" , "MP" , "UP" ,"Hariyana")
    private var cities = arrayOf("Surat" , "Baroda" , "Rajkot" , "Aamreli" , "Amadavad" , "Bhavnagar" , "Bharuch" , "Jamnagar")
    private lateinit var mAdapter: ArrayAdapter<String>
    private lateinit var mSpinner: ArrayAdapter<String>
    private lateinit var mgridview: ArrayAdapter<String>
    private lateinit var mAutoComplete:ArrayAdapter<String>





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ListView
        mAdapter  = ArrayAdapter(this , android.R.layout.simple_list_item_1 , language)
        binding.listView.adapter = mAdapter
        binding.listView.setOnItemClickListener { adapterView, view, pos, l ->

            var lang = language[pos]
            Toast.makeText(applicationContext , "$lang" , Toast.LENGTH_SHORT).show()
        }

        //  Spinner

        mSpinner = ArrayAdapter(this , android.R.layout.simple_spinner_dropdown_item , countries)
        binding.spinner.adapter = mSpinner
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {

                var country = countries[pos]
                Toast.makeText(applicationContext ,"$country" , Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }


        }

        // GridView

        mgridview = ArrayAdapter(this , android.R.layout.simple_list_item_1 , states)
        binding.gridView.adapter = mgridview
        binding.gridView.setOnItemClickListener { adapterView, view, pos , l ->

            var state = states[pos]
            Toast.makeText(applicationContext , "$state" , Toast.LENGTH_SHORT).show()
        }


        // AutoCompleteTextView

        mAutoComplete = ArrayAdapter(this , android.R.layout.simple_spinner_item , cities)
        binding.autoComplete.setAdapter(mAutoComplete)

        binding.autoComplete.setOnItemClickListener { adapterView, view, pos, l ->

            var city = adapterView.getItemAtPosition(pos)
            Toast.makeText(applicationContext , "$city" , Toast.LENGTH_SHORT).show()
        }



    }
}