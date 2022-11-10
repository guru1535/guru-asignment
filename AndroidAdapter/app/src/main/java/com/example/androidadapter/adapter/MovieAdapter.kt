package com.example.androidadapter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.androidadapter.databinding.ItemMovieLayoutBinding
import com.example.androidadapter.model.Movie

data class MovieAdapter(var context :Context , var movieList: MutableList<Movie>) : BaseAdapter(){

    private lateinit var binding: ItemMovieLayoutBinding



    override fun getCount(): Int {
        return movieList.size
    }

    override fun getItem(pos: Int): Any {
        return movieList[pos]
    }

    override fun getItemId(pos: Int): Long {
        return pos.toLong()
    }

    override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {

        binding = ItemMovieLayoutBinding.inflate(LayoutInflater.from(context) , parent , false)

        var movie = movieList[pos]
        binding.tvTitle.text = movie.title
        binding.tvType.text = movie.type
        binding.ratingBar.rating = movie.rating
        binding.tvYear.text = "${movie.year}"
        binding.ivThumbnail.setImageResource(movie.image)



        return  binding.root


    }

}
