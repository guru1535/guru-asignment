package com.example.autoslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.autoslider.Adapter.SliderAdapter
import com.example.autoslider.Model.Item
import com.example.autoslider.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var itemList = mutableListOf<Item>()
    private lateinit var sAdapter : SliderAdapter
    var currentIndex = 0

    companion object {
        private var currentPage = 0
        private var numPage = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()
        autoSlider()

       // updateIndicator(currentIndex)
    }

    private fun autoSlider() {

        sAdapter = SliderAdapter(this, itemList)
        binding.viewPager.adapter = sAdapter
        // updateIndicator(currentIndex)

        numPage = itemList.size
        updateIndicator(numPage)
        var handle = Handler()
        var updater = Runnable {
            if (currentPage == numPage) {
                currentPage = 0
            }
            //} else {
                binding.viewPager.setCurrentItem(currentPage++, true)
           // }
        }

        var swimTimer = Timer()
        swimTimer.schedule(object : TimerTask() {
            override fun run() {

                // handles.postDelayed(up,100)

                handle.post(updater)
            }

        }, 1000, 2000)

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {


            }

            override fun onPageSelected(position: Int) {
                currentPage=position
                updateIndicator(currentPage)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

    }

    private fun prepareData() {
        itemList.add(Item(1 , R.drawable.royal1))
        itemList.add(Item(2 , R.drawable.royal2))
        itemList.add(Item(3 , R.drawable.royal3))
        itemList.add(Item(4 , R.drawable.royal4))
        itemList.add(Item(5 , R.drawable.royal5))
        itemList.add(Item(6 , R.drawable.royal6))
      //  itemList.add(Item(7 , R.drawable.royal7))
      //  itemList.add(Item(8 , R.drawable.royal8))
      //  itemList.add(Item(9 , R.drawable.royal9))
      //  itemList.add(Item(9 , R.drawable.royal10))

    }


    private fun updateIndicator(currentIndex : Int){

        binding.layout.removeAllViews()

        var indicator= arrayOfNulls<ImageView>(numPage)


        for (i in indicator.indices){
            ///var view = ImageView(this)
            //view.layoutParams = lp

            indicator[i]= ImageView(this)

            if (currentIndex == i){
                indicator[i]?.setImageResource(R.drawable.active_indicator)
                // view.setImageResource(R.drawable.active_indicator)
            }else{
                indicator[i]?.setImageResource(R.drawable.inactive_indicator)
                //view.setImageResource(R.drawable.inactive_indicator)
            }
             var lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT , LinearLayout.LayoutParams.WRAP_CONTENT)
             lp.setMargins(10 , 0 , 10 , 0)
             binding.layout.addView(indicator[i],lp)
        }

       // var lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT , LinearLayout.LayoutParams.WRAP_CONTENT)
       // lp.setMargins(10 , 0 , 0 , 0)

    }
}

