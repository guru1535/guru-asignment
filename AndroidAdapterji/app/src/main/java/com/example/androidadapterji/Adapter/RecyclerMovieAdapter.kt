package com.example.androidadapterji.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidadapterji.Model.Movie
import com.example.androidadapterji.databinding.ItemMovieLayoutBinding

class RecyclerMovieAdapter(var context : Context ,var movieList: MutableList<Movie>) : RecyclerView.Adapter<RecyclerMovieAdapter.MyViewHolder>() {

    private lateinit var binding: ItemMovieLayoutBinding


    class MyViewHolder(var bind : ItemMovieLayoutBinding) : RecyclerView.ViewHolder(bind.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemMovieLayoutBinding.inflate(LayoutInflater.from(context),parent , false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var movie = movieList[position]

        holder.bind.tvTitle.text = movie.title
        holder.bind.tvType.text = movie.type
        holder.bind.ratingbar.rating = movie.rating
        holder.bind.tvYear.text = "${movie.year}"
        holder.bind.ivThumbnail.setImageResource(movie.image)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}