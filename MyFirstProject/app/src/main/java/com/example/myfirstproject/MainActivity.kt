package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFE-CYCLE" , "onStart:called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFE-CYCLE" , "onResume:called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFE-CYCLE" , "onRestart:called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFE-CYCLE" , "onPause:called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFE-CYCLE" , "onStop:called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFE-CYCLE" , "onDestroy:called ")
    }




}