package com.example.androidadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidadapter.databinding.ActivityCustomListBinding
import com.example.androidadapter.model.Movie
import com.example.androidadapter.adapter.MovieAdapter

class CustomListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomListBinding

    private var movieList = mutableListOf<Movie>()

    lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        //pass data to adapter using constructor
        adapter = MovieAdapter(this , movieList )
        // set adapter to adapterview
        binding.listView.adapter = adapter

    }

    private fun prepareData() {

        movieList.add(Movie(1 ,  "Love NI Bhavai" ,"Romantic ,Drama " , 2017 , 4.0f , R.drawable.love_ni_bhavai))
        movieList.add(Movie(2 ,  "Pushpa The Rise" ,"Action ,Drama " , 2021 , 4.5f , R.drawable.puspa_the_rise))
        movieList.add(Movie(3 ,  "R.R.R." ,"Action ,Drama " , 2022 , 4.7f , R.drawable.rrr))
        movieList.add(Movie(4 ,  "KGF Chapter - 2" ,"Action " , 2022 , 5.0f , R.drawable.kgf_2))
        movieList.add(Movie(5 ,  "Dear Father" ," Genre Comedy, Crime, Drama" , 2022 , 4.9f , R.drawable.dear_father))
    }
}