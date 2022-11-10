package com.example.androidassessment2022.Activity.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassessment2022.Activity.Model.Option
import com.example.androidassessment2022.databinding.OptionItemLayoutBinding

class OptionItemAdapter(var context: Context , var optionList: MutableList<Option>) : RecyclerView.Adapter<OptionItemAdapter.MyViewHolder>(){

    private lateinit var binding: OptionItemLayoutBinding

    class MyViewHolder(var bind: OptionItemLayoutBinding) : RecyclerView.ViewHolder(bind.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = OptionItemLayoutBinding.inflate(LayoutInflater.from(context) , parent , false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var option = optionList[position]
        holder.bind.playQuiz.setOnClickListener {


        }
        holder.bind.readQuestions.setOnClickListener {


        }



    }

    override fun getItemCount(): Int {
        return optionList.size
    }
}