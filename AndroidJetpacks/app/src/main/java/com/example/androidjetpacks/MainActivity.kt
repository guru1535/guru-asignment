package com.example.androidjetpacks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.androidjetpacks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)


        mainViewModel = ViewModelProvider(this , MainViewModelFactory(10)).get(mainViewModel :: class.java)

        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this

        // when counter value from view model is changed..then this method called automatically
       /* mainViewModel.mutableLiveData.observe(this , Observer {

            binding.tvCounter.text = "$it"
        })*/

      //  updateCounter()



      /*  binding.btnPlus.setOnClickListener {
            mainViewModel.increaseValue()
          //  updateCounter()
        }


        binding.btnMinus.setOnClickListener {
           mainViewModel.decreaseValue()
          //  updateCounter()
        }*/

    }



    //private fun updateCounter() {
       // binding.tvCounter.text = "${mainViewModel.counter}"
   // }
}