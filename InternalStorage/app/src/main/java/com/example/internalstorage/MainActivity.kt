package com.example.internalstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.internalstorage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val DIR_NAME = "tops.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSave.setOnClickListener {

            var message = binding.etMessage.text.toString().trim()

            var fos = openFileOutput(DIR_NAME , MODE_PRIVATE)

            fos?.let {
                it.write(message.toByteArray())
            }
            fos.close()

            Toast.makeText(applicationContext, "File Saved", Toast.LENGTH_SHORT).show()

        }

        binding.btnRead.setOnClickListener{

            var fin = openFileInput(DIR_NAME)
            var array = ByteArray(fin.available())
            fin.read(array)
            var message = String(array)
            binding.tvResult.text = message


        }
    }
}