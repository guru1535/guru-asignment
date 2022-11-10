package com.example.recycleractivityprojectextra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleractivityprojectextra.Adapter.RecyclerMovieAdapter
import com.example.recycleractivityprojectextra.Model.Movie
import com.example.recycleractivityprojectextra.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBinding

    private var movieList = mutableListOf<Movie>()

    private lateinit var mAdapter: RecyclerMovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        // pass data to adapter using constructor

        mAdapter = RecyclerMovieAdapter(this , movieList)

        var manager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = manager

        // pass adapter to adapter view
        binding.recyclerView.adapter = mAdapter

    }

    private fun prepareData() {

        movieList.add(Movie(1 , "Love Ni Bhavai" , "Romantic Drama" , 2017 , 4.2f ,R.drawable.love_ni_bhavai ))
        movieList.add(Movie(2 , "Pushpa The Rise" , "Action , Drama" , 2021 , 4.6f , R.drawable.puspa_the_rise))
        movieList.add(Movie(3 , "R.R.R." , "Action , Comedy" , 2022 , 5.0f , R.drawable.rrr))
        movieList.add(Movie(4 , "KGF Chapter -2" , "Action" , 2022 , 5.0f , R.drawable.kgf_2))
        movieList.add(Movie(5 , "Dear Father" , "Comedy , Crime , Drama" ,2022 , 4.5f , R.drawable.dear_father))
        movieList.add(Movie(6 , "Love Ni Bhavai" , "Romantic Drama" , 2017 , 4.2f ,R.drawable.love_ni_bhavai ))
        movieList.add(Movie(7 , "Pushpa The Rise" , "Action , Drama" , 2021 , 4.6f , R.drawable.puspa_the_rise))
        movieList.add(Movie(8 , "R.R.R." , "Action , Comedy" , 2022 , 5.0f , R.drawable.rrr))
        movieList.add(Movie(9 , "KGF Chapter -2" , "Action" , 2022 , 5.0f , R.drawable.kgf_2))
        movieList.add(Movie(0 , "Dear Father" , "Comedy , Crime , Drama" ,2022 , 4.5f , R.drawable.dear_father))

    }
}