package com.example.kevalproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.kevalproject.Model.BoardingItem
import com.example.kevalproject.databinding.IntroSliderLayoutBinding

class ItemPagerAdapter(var context: Context , var boardingItemList : MutableList<BoardingItem>) : PagerAdapter() {

    private lateinit var binding: IntroSliderLayoutBinding

    override fun getCount(): Int {
      return boardingItemList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        binding = IntroSliderLayoutBinding.inflate(LayoutInflater.from(context) , container , false)

        var boardingItem = boardingItemList[position]

        binding.tvTitle.text = boardingItem.title
        binding.tvDesc.text = boardingItem.desc
        binding.ivThumbnail.setImageResource(boardingItem.image)

        container.addView(binding.root)
        return binding.root

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
    }
}