package com.example.myfinalfragmentproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfinalfragmentproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var fragment = FirstFragment()


        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()

        transaction.add(R.id.fragment_container , fragment)
        transaction.commit()
    }
}