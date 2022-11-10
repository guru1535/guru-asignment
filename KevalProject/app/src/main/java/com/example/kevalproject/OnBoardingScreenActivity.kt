package com.example.kevalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.setMargins
import androidx.viewpager.widget.ViewPager
import com.example.kevalproject.Adapter.ItemPagerAdapter
import com.example.kevalproject.Model.BoardingItem
import com.example.kevalproject.databinding.ActivityLoginBinding
import com.example.kevalproject.databinding.ActivityOnBoardingScreenBinding

class OnBoardingScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingScreenBinding
    private var boardingItemList = mutableListOf<BoardingItem>()
    private lateinit var oAdapter: ItemPagerAdapter
    var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        binding.btnSkip.setOnClickListener {

            var intent = Intent(applicationContext , LoginActivity::class.java)
            startActivity(intent)

        }

        binding.btnNext.setOnClickListener {
            if (currentIndex == oAdapter.count-1){

                // navigate to login activity.

                var intent = Intent(applicationContext , LoginActivity::class.java)
                startActivity(intent)

            }else {
                currentIndex++
                binding.viewPager.currentItem = currentIndex
            }

        }

        oAdapter = ItemPagerAdapter(this , boardingItemList)
        binding.viewPager.adapter = oAdapter

        updateIndicator(currentIndex)

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                currentIndex = position

                if (currentIndex==oAdapter.count-1){
                    binding.btnNext.text = "Finish"
                }else {
                    binding.btnNext.text = "Next"
                }

                updateIndicator(currentIndex)
               // Toast.makeText(applicationContext, "$position", Toast.LENGTH_SHORT).show()
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })


    }

    private fun prepareData() {
        boardingItemList.add(BoardingItem(1 , "Pick up or delivery" , "We are gradually adding new functionality and we welcome your suggestions and feedback" , R.drawable.img2))
        boardingItemList.add(BoardingItem(2 , "Pay quick and easy" , "Please feel free to send us any additional dummy text." , R.drawable.img3))
    }

    private fun updateIndicator(currentIndex : Int){

        binding.layoutDot.removeAllViews()

        var lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT , LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.setMargins(10,0,0,0)
        for (i in boardingItemList.indices){
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