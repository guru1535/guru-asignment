package com.example.getrequestwithheader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.getrequestwithheader.Model.City
import com.example.getrequestwithheader.Model.Country
import com.example.getrequestwithheader.Model.States
import com.example.getrequestwithheader.Network.ApiClient
import com.example.getrequestwithheader.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var countryAdapter: ArrayAdapter<Country>
    lateinit var stateAdapter: ArrayAdapter<States>
    lateinit var cityAdapter: ArrayAdapter<City>
    var countryList = mutableListOf<Country>()
    var stateList = mutableListOf<States>()
    var cityList = mutableListOf<City>()

    var country = ""
    var state = ""
    var city  = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadCountryList()


    }

    private fun loadCountryList() {

        ApiClient.init().getCountry().enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {

                if (response.isSuccessful){
                    countryList = response.body() as MutableList<Country>

                    countryAdapter = ArrayAdapter(applicationContext , android.R.layout.simple_spinner_dropdown_item , countryList)
                    binding.autoCountry.setAdapter(countryAdapter)

                    binding.autoCountry.setOnItemClickListener { adapterView, view, i, l ->

                        country = countryList[i].name
                        getStateList(country)
                    }


                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {

                // Failure
            }

        })
    }

    private fun getStateList(country: String) {

        binding.autoState.clearListSelection()
        state = ""

        ApiClient.init().getState(country).equals(object :Callback<List<States>>  {
            override fun onResponse(call: Call<List<States>>, response: Response<List<States>>) {

                if (response.isSuccessful){
                    stateList = response.body() as MutableList<States>

                    stateAdapter = ArrayAdapter(applicationContext , android.R.layout.simple_spinner_dropdown_item , stateList)

                    binding.autoState.setAdapter(stateAdapter)

                    binding.autoState.setOnItemClickListener { adapterView, view, i, l ->

                        state = stateList[i].stateName
                        getCityList()
                    }

                }

            }

            override fun onFailure(call: Call<List<States>>, t: Throwable) {

            }

        })
    }

    private fun getCityList() {

        binding.autoCity.clearListSelection()
        city = ""

        ApiClient.init().getCity(state).enqueue(object : Callback<List<City>>  {
            override fun onResponse(call: Call<List<City>>, response: Response<List<City>>) {

                if (response.isSuccessful){
                    cityList = response.body() as MutableList<City>

                    cityAdapter = ArrayAdapter(applicationContext , android.R.layout.simple_spinner_dropdown_item , cityList)
                    binding.autoCity.setAdapter(cityAdapter)

                    binding.autoCity.setOnItemClickListener { adapterView, view, i, l ->

                        city = cityList[i].cityName
                    }
                }


            }

            override fun onFailure(call: Call<List<City>>, t: Throwable) {

            }

        })

    }
}