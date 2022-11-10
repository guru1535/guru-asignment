package com.example.myfirstfragmentproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstfragmentproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        var fragment = FirstFragment()


        var manager = supportFragmentManager                      // TYPE: FragmentManager
        var transaction = manager.beginTransaction()               // TYPE : FragmentTransaction

        transaction.add(R.id.fragment_container , fragment)
        transaction.commit()






    }
}