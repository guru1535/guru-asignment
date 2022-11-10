package com.example.viewpager2.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onboardingscreenextra.Model.Item
import com.example.viewpager2.databinding.IntroSliderLayoutBinding

class ItemAdapter(var context: Context,var list: MutableList<Item>):RecyclerView.Adapter<ItemAdapter.ViewData>() {

    lateinit var binding: IntroSliderLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        binding= IntroSliderLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewData(binding)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        var listdata=list[position]
        holder.bind.tvTitle.text=listdata.title
        holder.bind.tvDesc.text=listdata.desc
        holder.bind.ivThumbnail.setImageResource(listdata.image)
    }

    override fun getItemCount(): Int {
         return list.size
    }


    class ViewData(var bind: IntroSliderLayoutBinding) : RecyclerView.ViewHolder(bind.root){

    }
}