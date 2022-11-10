package com.example.viewpager2recyclerview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2recyclerview.Model.Item
import com.example.viewpager2recyclerview.databinding.IntroSliderLayoutBinding

class ItemAdapter(var context: Context , var itemList : MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ViewData>() {

    private lateinit var binding: IntroSliderLayoutBinding

    class ViewData(var bind :IntroSliderLayoutBinding ) : RecyclerView.ViewHolder(bind.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {

        binding = IntroSliderLayoutBinding.inflate(LayoutInflater.from(context) , parent , false)
        return ViewData(binding)

    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {

        var item = itemList[position]

        holder.bind.tvTitle.text = item.title
        holder.bind.tvDesc.text = item.desc
        holder.bind.ivThumbnail.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}