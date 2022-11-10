package com.example.viewpager2fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.viewpager2fragment.Adapter.ItemAdapter
import com.example.viewpager2fragment.Model.Item
import com.example.viewpager2fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var itemList = mutableListOf<Item>()
    private lateinit var mfragAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        prepareData()

        mfragAdapter = ItemAdapter(itemList , this)
        binding.viewPager.adapter = mfragAdapter
        binding.viewPager.setCurrentItem(0 , true)
    }

    private fun prepareData() {

        itemList.add(Item(1 , "Choose your item" , "This handy tool help you create dummy text for all your layout need." , R.drawable.img1))
        itemList.add(Item(2 , "Pick up or delivery" , "We are gradually adding new functionality and we welcome your suggestions and feedback." , R.drawable.img2))
        itemList.add(Item(3 , "Pay quick and easy" , "Please feel free to send us any additional dummy text.  " , R.drawable.img3))





    }
}