package com.example.recycleractivityproject.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleractivityproject.Listner.OnMovieItemClickListner
import com.example.recycleractivityproject.Model.Movie
import com.example.recycleractivityproject.MovieDetailActivity
import com.example.recycleractivityproject.databinding.ItemMovieLayoutBinding

class RecyclerMovieAdapter(var context: Context ,var movieList: MutableList<Movie>) : RecyclerView.Adapter<RecyclerMovieAdapter.MyViewHolder>(){

    private lateinit var binding: ItemMovieLayoutBinding

    private lateinit var clickListner: OnMovieItemClickListner

    fun setOnMovieItemClickedListner(clickListner: OnMovieItemClickListner){
        this.clickListner = clickListner
    }

    class MyViewHolder(var bind : ItemMovieLayoutBinding) : RecyclerView.ViewHolder(bind.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemMovieLayoutBinding.inflate(LayoutInflater.from(context) , parent ,false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var movie = movieList[position]

        holder.bind.tvTitle.text = movie.title
        holder.bind.tvType.text = movie.type
        holder.bind.ratingbar.rating = movie.rating
        holder.bind.tvYear.text = "${movie.year}"
        holder.bind.ivThumnail.setImageResource(movie.image)


        holder.bind.cardParent.setOnClickListener {

            clickListner.onCradClicked(movie , position)

        }

        holder.bind.ivThumnail.setOnClickListener {

            clickListner.onImageClicked(movie)

        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}