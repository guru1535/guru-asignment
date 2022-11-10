package com.example.basiccalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.basiccalculation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {

            if (binding.etNo1.text.toString()!= "" && binding.etNo2.text.toString()!=""){

                val no1 = binding.etNo1.text.toString().trim().toInt()
                val no2 = binding.etNo2.text.toString().trim().toInt()

                val add = no1+no2
                Toast.makeText(applicationContext, "The addition Of Two Number Is $add", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(applicationContext, "Please Enter Your Number", Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnMinus.setOnClickListener {

            if (binding.etNo1.text.toString()!= "" && binding.etNo2.text.toString()!=""){

                val no1 = binding.etNo1.text.toString().trim().toInt()
                val no2 = binding.etNo2.text.toString().trim().toInt()

                var minus : Int

                if (no1>no2){
                    minus = no1 - no2
                }else{
                    minus = no2 - no1
                }


                Toast.makeText(applicationContext, "The subtraction Of Two Number Is $minus", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(applicationContext, "Please Enter Your Number", Toast.LENGTH_SHORT).show()
            }
        }


        binding.btnMultiplication.setOnClickListener {

            if (binding.etNo1.text.toString()!= "" && binding.etNo2.text.toString()!=""){

                val no1 = binding.etNo1.text.toString().trim().toInt()
                val no2 = binding.etNo2.text.toString().trim().toInt()

                val multiplication = no1*no2
                Toast.makeText(applicationContext, "The multiplication Of Two Number Is $multiplication", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(applicationContext, "Please Enter Your Number", Toast.LENGTH_SHORT).show()
            }
        }


        binding.btnDivision.setOnClickListener {

            if (binding.etNo1.text.toString()!= "" && binding.etNo2.text.toString()!=""){

                val no1 = binding.etNo1.text.toString().trim().toInt()
                val no2 = binding.etNo2.text.toString().trim().toInt()

                var division : Int
                if (no2==0){
                    division = 0
                    Toast.makeText(applicationContext, "A number can't devided by zero", Toast.LENGTH_SHORT).show()
                }else{
                     division = no1/no2

                }
                Toast.makeText(applicationContext, "The division Of Two Number Is $division", Toast.LENGTH_SHORT).show()


            }else{
                Toast.makeText(applicationContext, "Please Enter Your Number", Toast.LENGTH_SHORT).show()
            }
        }


    }
}