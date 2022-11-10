package com.example.viewpagerfinaly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.setMargins
import androidx.viewpager.widget.ViewPager
import com.example.viewpagerfinaly.Adapter.ItemPagerAdapter
import com.example.viewpagerfinaly.Model.Item
import com.example.viewpagerfinaly.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var itemList = mutableListOf<Item>()
    private lateinit var mAdapter: ItemPagerAdapter
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        prepareData()

        // btn skip click event
        binding.btnSkip.setOnClickListener {
            Toast.makeText(applicationContext, "Navigate to login page", Toast.LENGTH_SHORT).show()
        }




        // btn next click event
        binding.btnNext.setOnClickListener {

            if (currentIndex == mAdapter.count-1){
                Toast.makeText(applicationContext, "Navigate to Login page", Toast.LENGTH_SHORT).show()
            }else{

                currentIndex++
                binding.viewPager.currentItem = currentIndex
            }

        }





        mAdapter = ItemPagerAdapter(this , itemList)
        binding.viewPager.adapter = mAdapter

        updateIndicator(currentIndex)


        // first part of btn clicked and pager selection
        binding.viewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }


            override fun onPageSelected(position: Int) {
                currentIndex = position

                if (currentIndex==mAdapter.count-1){

                    binding.btnNext.text = "Finish"
                }else{
                    binding.btnNext.text = "Next"
                }
                updateIndicator(currentIndex)
                Toast.makeText(applicationContext, "$position", Toast.LENGTH_SHORT).show()

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }

    private fun prepareData() {

        itemList.add(Item(1 , "Choose your item" , "This handy tool help you create dummy text for all your layout need." , R.drawable.img1))
        itemList.add(Item(2 , "Pick up or delivery" , "We are gradually adding new functionality and we welcome your suggestions and feedback." , R.drawable.img2))
        itemList.add(Item(3 , "Pay quick and easy" , "Please feel free to send us any additional dummy text.  " , R.drawable.img3))



    }

    // indicator code

    private fun updateIndicator(currentIndex : Int){

        binding.layoutDot.removeAllViews()

        var lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT , LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.setMargins(10 , 0 , 0 , 0)

        for (i in itemList.indices){


            var view = ImageView(applicationContext)
            view.layoutParams = lp

            if (i == currentIndex){
                view.setImageResource(R.drawable.active_indicator)
            }else{
                view.setImageResource(R.drawable.inactive_indicator)

            }
            binding.layoutDot.addView(view)
        }

    }
}