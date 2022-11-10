package com.example.customlistadapter.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.customlistadapter.Model.Movie
import com.example.customlistadapter.databinding.ItemMovieLayoutBinding

class MovieAdapter(var context: Context , var movieList: MutableList<Movie>) : BaseAdapter() {

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

        var Movie = movieList[pos]

        binding.tvTitle.text = Movie.title
        binding.tvType.text = Movie.type
        binding.ratingbar.rating = Movie.rating
        binding.tvYear.text = "${Movie.year}"
        binding.ivThumnail.setImageResource(Movie.image )


        return binding.root

    }
}