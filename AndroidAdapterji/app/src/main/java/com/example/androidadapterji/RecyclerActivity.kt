package com.example.androidadapterji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidadapterji.Adapter.RecyclerMovieAdapter
import com.example.androidadapterji.Model.Movie
import com.example.androidadapterji.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRecyclerBinding
    private var movieList = mutableListOf<Movie>()

    private lateinit var mAdapter:RecyclerMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()


        // pass data adapter to adapter
        mAdapter = RecyclerMovieAdapter( this , movieList)
        var manager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = manager
        // set mAdapter to Adapter view
        binding.recyclerView.adapter = mAdapter
    }

    private fun prepareData() {
        movieList.add(Movie(1 , "Love Ni Bhavai" , "Gujarati Drama and Comedy" ,2017 , 4.5f , R.drawable.love_ni_bhavai))
        movieList.add(Movie(2 , "Pushpa : The Rise" , "Drama , Action" ,2021 , 4.9f , R.drawable.puspa_the_rise))
        movieList.add(Movie(3 , "R.R.R." , "Drama , Action" ,2022 , 4.9f , R.drawable.rrr))
        movieList.add(Movie(4 , "KGF : Chapter - 2" , "Action" ,2022 , 5.0f , R.drawable.kgf_2))
        movieList.add(Movie(5 , "Dear Father" , "Drama , Crime , Comedy" ,2022 , 4.8f , R.drawable.dear_father))
        movieList.add(Movie(6 , "Love Ni Bhavai" , "Gujarati Drama and Comedy" ,2017 , 4.5f , R.drawable.love_ni_bhavai))
        movieList.add(Movie(7 , "Pushpa : The Rise" , "Drama , Action" ,2021 , 4.9f , R.drawable.puspa_the_rise))
        movieList.add(Movie(8 , "R.R.R." , "Drama , Action" ,2022 , 4.9f , R.drawable.rrr))
        movieList.add(Movie(9 , "KGF : Chapter - 2" , "Action" ,2022 , 5.0f , R.drawable.kgf_2))
        movieList.add(Movie(10 , "Dear Father" , "Drama , Crime , Comedy" ,2022 , 4.8f , R.drawable.dear_father))

    }
}