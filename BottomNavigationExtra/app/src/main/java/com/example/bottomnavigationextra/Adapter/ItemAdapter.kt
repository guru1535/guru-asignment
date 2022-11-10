package com.example.bottomnavigationextra.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigationextra.Model.Item
import com.example.bottomnavigationextra.databinding.FragmentHomeBinding
import com.example.bottomnavigationextra.databinding.ItemLayoutBinding

class ItemAdapter(var context: Context , var itemList: MutableList<Item>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var binding: ItemLayoutBinding

    class MyViewHolder(var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        binding = ItemLayoutBinding.inflate(LayoutInflater.from(context) , parent , false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var item = itemList[position]

        binding.tvTitle.text = item.title
        binding.ratingbar.rating = item.rating
        binding.ivThumbnail.setImageResource(item.image)

    }

    override fun getItemCount(): Int {
       return itemList.size
    }
}