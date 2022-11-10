package com.example.kevalproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.kevalproject.Model.Item
import com.example.kevalproject.databinding.ItemLayoutBinding

class ItemListAdapter(var context: Context , var itemList: MutableList<Item>):BaseAdapter() {

    private lateinit var binding: ItemLayoutBinding
    override fun getCount(): Int {
        return itemList.size
    }

    override fun getItem(position: Int): Any {
       return itemList[position]
    }

    override fun getItemId(position: Int): Long {
      return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {

        binding = ItemLayoutBinding.inflate(LayoutInflater.from(context) , parent , false)

        var item = itemList[position]

        binding.tvTitle.text = item.title
        binding.ivThumbnail.setImageResource(item.image)

        return binding.root

    }
}