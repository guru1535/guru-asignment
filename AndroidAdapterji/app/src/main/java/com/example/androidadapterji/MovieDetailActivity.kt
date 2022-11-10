package com.example.androidadapterji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidadapterji.Model.Movie
import com.example.androidadapterji.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var movie = intent.getParcelableExtra<Movie>("MOVIE")

        movie?.let {

            binding.ivThumbnail.setImageResource(it.image)
            binding.tvTitle.text = it.title
            binding.tvType.text = it.type
            binding.ratingbar.rating = it.rating

        }

    }
}