package com.example.recyclerviewextra.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewextra.Model.Movie
import com.example.recyclerviewextra.MovieDetailActivity
import com.example.recyclerviewextra.databinding.ItemMovieLayoutBinding
import com.example.recyclerviewextra.listner.OnMovieItemClickedListner

class RecyclerMovieAdapter(var context: Context , var movieList: MutableList<Movie>) :RecyclerView.Adapter<RecyclerMovieAdapter.MyViewHolder>(){

    private lateinit var binding: ItemMovieLayoutBinding

    private lateinit var clickedListner: OnMovieItemClickedListner

    fun setOnMovieItemClickedListner(clickedListner: OnMovieItemClickedListner){

        this.clickedListner = clickedListner
    }

    class MyViewHolder(var binding: ItemMovieLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemMovieLayoutBinding.inflate(LayoutInflater.from(context) , parent , false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var movie = movieList[position]

        holder.binding.tvTitle.text = movie.title
        holder.binding.tvType.text = movie.type
        holder.binding.tvYear.text = "${movie.year}"
        holder.binding.ratingbar.rating = movie.rating
        holder.binding.ivThubnail.setImageResource(movie.image)


        holder.binding.cardParent.setOnClickListener {

            clickedListner.onCardClicked(movie , position)

        }

        holder.binding.ivThubnail.setOnClickListener {

            clickedListner.onImageClicked(movie)


        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}