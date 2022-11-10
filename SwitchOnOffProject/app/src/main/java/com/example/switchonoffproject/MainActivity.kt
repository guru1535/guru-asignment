package com.example.switchonoffproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.switchonoffproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switch2.setOnCheckedChangeListener { compoundButton, isChecked ->


            if (isChecked){
                binding.switch2.text = resources.getString(R.string.lightison)
                binding.imageView.setImageResource(R.drawable.bon)
            }else{
                binding.switch2.text = resources.getString(R.string.lightisoff)
                binding.imageView.setImageResource(R.drawable.boff)
            }

    }
}
}