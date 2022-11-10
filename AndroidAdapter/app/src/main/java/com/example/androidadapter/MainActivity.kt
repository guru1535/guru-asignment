package com.example.androidadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.androidadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var language = arrayOf("java" , "kotlin" , "java script" ,"dart" , "python" , " c++" )
    private var counties = arrayOf("India" , "Russia" , "Bhutan" , "Japan" , "Poland" , "Germany" , "Australia")
    private var states = arrayOf("Gujarat" , "Maharastra" , "MP" , "Up" , "bihar" , "Odissa" )
    private var cities = arrayOf("Surat" , "Vadodara" , "Rajkot" , "Mumbai" , "Kolkata" , "Banglore")
    private lateinit var mAdapter: ArrayAdapter<String>
    private lateinit var mSpinnerAdapter: ArrayAdapter<String>
    private lateinit var mGridAdapter: ArrayAdapter<String>
    private lateinit var mAutoCompleteAdapter: ArrayAdapter<String>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // List View

        // passing data to adapter
        mAdapter = ArrayAdapter(this , android.R.layout.simple_list_item_1 , language)
        // set adapter to adapter view
        binding.listView.adapter = mAdapter
        // listview item click event
        binding.listView.setOnItemClickListener { adapterView, view, position, l ->

            var lang = language[position]
            Toast.makeText(applicationContext , "$lang" , Toast.LENGTH_SHORT).show()

           /* var intent = Intent(this , DestinationActivity :: class.java)
            intent.putExtra("LANG" , lang)
            startActivity(intent)*/

        }


        // Spinner

        // passing data to adapter using constructor
        mSpinnerAdapter = ArrayAdapter(this , android.R.layout.simple_spinner_item, counties)
        // set adapter to adapter view using setAdapter method
        binding.spinner.adapter = mSpinnerAdapter
        // spinner item selection event

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {

                var country = counties[pos]
                Toast.makeText(applicationContext , "$country" , Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }


        // Grid View
        //  passing data to adapter using constructor
        mGridAdapter = ArrayAdapter(this , android.R.layout.simple_list_item_1 , states)
        //  set adapter to adapter view using setAdapter method
        binding.gridView.adapter = mGridAdapter

        // GridView  item selection event

        binding.gridView.setOnItemClickListener { adapterView, view, pos, l ->

            var state = states[pos]
            Toast.makeText(applicationContext ,"$state" , Toast.LENGTH_SHORT).show()

        }

        // Auto Complete text view

        mAutoCompleteAdapter = ArrayAdapter(this , android.R.layout.simple_spinner_item , cities)

        binding.autoText.setAdapter(mAutoCompleteAdapter)

        binding.autoText.setOnItemClickListener { adapterView, view, pos, l ->

           /* var tView = view as TextView
            var city = tView.text*/

            var city = adapterView.getItemAtPosition(pos)
            Toast.makeText(applicationContext ,"$city" , Toast.LENGTH_SHORT).show()
        }




    }
}