package com.example.nestedrecyclerviewextra.Adapter

import android.content.Context
import android.telephony.SmsMessage
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerviewextra.Model.Category
import com.example.nestedrecyclerviewextra.Model.SubCategory
import com.example.nestedrecyclerviewextra.databinding.ItemChildLayoutBinding
import com.example.nestedrecyclerviewextra.databinding.ItemParentLayoutBinding

class SubCategoryAdapter(var context: Context, var subCategoryList: MutableList<SubCategory> ,var listner: CategoryAdapter.ItemClickListner) : RecyclerView.Adapter<SubCategoryAdapter.MyViewHolder>() {

    lateinit var binding: ItemChildLayoutBinding

    class MyViewHolder(var binding: ItemChildLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemChildLayoutBinding.inflate(LayoutInflater.from(context) , parent , false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var subCategory = subCategoryList[position]
        holder.binding.tvTitle.text = subCategory.name
        holder.binding.ivThubnail.setImageResource(subCategory.image)

        holder.binding.cardParent.setOnClickListener {

            listner.onChildItemClicked(it , subCategory)
        }
    }

    override fun getItemCount(): Int {
        return subCategoryList.size
    }


}