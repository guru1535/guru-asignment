package com.example.myroomdatabase.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myroomdatabase.Database.Entity.User
import com.example.myroomdatabase.databinding.ItemUserLayoutBinding

class RecyclerUserAdapter(var context: Context , var userList: MutableList<User>) :RecyclerView.Adapter<RecyclerUserAdapter.MyViewHolder>(){

    private lateinit var binding: ItemUserLayoutBinding
    lateinit var onClickListener :OnListItemClickListner
    interface OnListItemClickListner{
        fun onDeleteItemClicked(user: User)
        fun onUpdateItemClicked(user: User)
    }
    fun setOnListItemClickListner(onClickListener:OnListItemClickListner){
        this.onClickListener = onClickListener
    }

    class MyViewHolder(var bind : ItemUserLayoutBinding) : RecyclerView.ViewHolder(bind.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemUserLayoutBinding.inflate(LayoutInflater.from(context) , parent , false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var user = userList[position]

       holder.bind.tvId.text = "${user.id}"
       holder.bind.tvName.text = "${user.name}"
       holder.bind.tvEmail.text = "${user.email}"

       holder.bind.ivDelete.setOnClickListener {

           onClickListener.onDeleteItemClicked(user)

       }

        holder.bind.ivEdit.setOnClickListener {
            onClickListener.onUpdateItemClicked(user)
        }


    }

    override fun getItemCount(): Int {
      return userList.size
    }

    fun setItem(userList: MutableList<User>){

        this.userList = userList
        notifyDataSetChanged()

    }
}