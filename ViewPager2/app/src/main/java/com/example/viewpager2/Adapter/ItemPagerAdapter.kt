package com.example.onboardingscreenextra.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.onboardingscreenextra.Model.Item
import com.example.viewpager2.itemFragment

class ItemPagerAdapter(
    var itemList: MutableList<Item>,
    var fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun createFragment(position: Int): Fragment {

        return itemFragment(itemList.get(position).image,itemList.get(position).title,itemList.get(position).desc)

    }


}