package com.example.nestedrecyclerviewextra.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerviewextra.Model.Category
import com.example.nestedrecyclerviewextra.Model.SubCategory
import com.example.nestedrecyclerviewextra.databinding.ActivityMainBinding
import com.example.nestedrecyclerviewextra.databinding.ItemParentLayoutBinding

class CategoryAdapter(var context: Context , var categoryList: MutableList<Category>) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    lateinit var binding: ItemParentLayoutBinding
    lateinit var listner :ItemClickListner


    interface ItemClickListner{
        fun viewAllClicked(id : Int , position: Int , title : String)
        fun onChildItemClicked(view: View , subCategory: SubCategory)
    }

    fun setOnItemClickListner(listner: ItemClickListner){
        this.listner = listner
    }

    class MyViewHolder(var binding: ItemParentLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemParentLayoutBinding.inflate(LayoutInflater.from(context) , parent , false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var category = categoryList[position]
        holder.binding.tvTitle.text = category.title


        var adapter = SubCategoryAdapter(context , category.movieList , listner)
        binding.childView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false)
        binding.childView.adapter = adapter


        holder.binding.btnViewAll.setOnClickListener {

            listner.viewAllClicked(category.id , position  , category.title)


        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }


}