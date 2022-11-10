package com.example.viewpager2fragment.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager2fragment.ItemFragment
import com.example.viewpager2fragment.Model.Item

class ItemAdapter(var itemList : MutableList<Item>, var fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun createFragment(position: Int): Fragment {
     return ItemFragment(itemList.get(position).image , itemList.get(position).title , itemList.get(position).desc)
    }
}