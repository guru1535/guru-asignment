package com.example.retrofitgetrequest.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitgetrequest.Model.User
import com.example.retrofitgetrequest.R
import com.example.retrofitgetrequest.databinding.ItemUserLayoutBinding

class UserListAdapter(var context: Context , var userList : MutableList<User>) : RecyclerView.Adapter<UserListAdapter.MyViewHolder>(){

    private lateinit var binding: ItemUserLayoutBinding

    class MyViewHolder(var bind : ItemUserLayoutBinding) : RecyclerView.ViewHolder(bind.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       binding = ItemUserLayoutBinding.inflate(LayoutInflater.from(context) , parent , false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var user = userList[position]

        holder.bind.tvName.text = "${user.fName} ${user.lName}"
        holder.bind.tvEmail.text = "${user.email}"

        Glide
            .with(context)
            .load(user.profileUrl)
            .centerCrop()
            .placeholder(R.drawable.hourglass)
            .into(holder.bind.ivThumbnail)

    }

    override fun getItemCount(): Int {

        return userList.size
    }

    fun setItem(userList: MutableList<User>){
        this.userList = userList
        notifyDataSetChanged()
    }
}