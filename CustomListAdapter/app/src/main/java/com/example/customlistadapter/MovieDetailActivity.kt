package com.example.customlistadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customlistadapter.Model.Movie
import com.example.customlistadapter.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var movie = intent.getParcelableExtra<Movie>("MOVIE")

        movie?.let {

            binding.ivThumnail.setImageResource(it.image)
            binding.tvTitle.text = it.title
            binding.tvType.text = it.type
            binding.ratingbar.rating = it.rating
            binding.tvYear.text = "${it.year}"

        }
    }
}