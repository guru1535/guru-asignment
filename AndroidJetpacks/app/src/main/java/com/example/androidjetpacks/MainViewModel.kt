package com.example.androidjetpacks

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(var num : Int) : ViewModel() {

   private var counter = num

    var mutableLiveData = MutableLiveData(num)

     fun increaseValue() {
        mutableLiveData.value = ++counter

    }

     fun decreaseValue(){
       mutableLiveData.value = --counter

    }
}