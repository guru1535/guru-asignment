package com.example.customlistadapterextra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customlistadapterextra.Model.Movie
import com.example.customlistadapterextra.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var movie = intent.getParcelableExtra<Movie>("MOVIE")

        movie?.let {

            binding.ivThubnail.setImageResource(it.image)
            binding.tvTitle.text = it.title
            binding.tvType.text = it.type
            binding.ratingbar.rating = it.rating
            binding.tvYear.text = "${it.year}"
        }
    }
}