package com.example.androidadapterji.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.androidadapterji.Model.Movie
import com.example.androidadapterji.databinding.ItemMovieLayoutBinding

class MovieAdapter(var context : Context , var movieList: MutableList<Movie>) : BaseAdapter() {

    private lateinit var binding: ItemMovieLayoutBinding

    override fun getCount(): Int {
        return movieList.size

    }

    override fun getItem(position: Int): Any {
        return movieList[position]
    }

    override fun getItemId(pos: Int): Long {
        return pos.toLong()
    }

    override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {

        binding = ItemMovieLayoutBinding.inflate(LayoutInflater.from(context) ,parent , false )

        var movie = movieList[pos]
        binding.tvTitle.text = movie.title
        binding.tvType.text = movie.type
        binding.ratingbar.rating = movie.rating
        binding.tvYear.text = "${movie.year}"
        binding.ivThumbnail.setImageResource(movie.image)

        return binding.root



    }
}