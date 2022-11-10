package com.example.customlistadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.customlistadapter.Adapter.MovieAdapter
import com.example.customlistadapter.Model.Movie
import com.example.customlistadapter.databinding.ActivityCustomListBinding

class CustomListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomListBinding

    private var movieList = mutableListOf<Movie>()

    lateinit var adapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityCustomListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        prepareData()

        // pass data to adapter using constructor

        adapter = MovieAdapter(this , movieList)

        // set adapter to adapter view

        binding.listView.adapter = adapter

        // click event of CustomListAdapter

        binding.listView.setOnItemClickListener { adapterView, view, pos, l ->

            var movie  = movieList[pos]

            intent = Intent(applicationContext , MovieDetailActivity ::class.java)
            intent.putExtra("MOVIE" , movie)
            startActivity(intent)

            //Toast.makeText(applicationContext , "${Movie.title}" , Toast.LENGTH_SHORT).show()
        }

    }

    private fun prepareData() {

        movieList.add(Movie(1 , "Love Ni Bhavai" , "Romantic Drama" , 2017 , 4.2f ,R.drawable.love_ni_bhavai ))
        movieList.add(Movie(2 , "Pushpa The Rise" , "Action , Drama" , 2021 , 4.6f , R.drawable.puspa_the_rise))
        movieList.add(Movie(3 , "R.R.R." , "Action , Comedy" , 2022 , 5.0f , R.drawable.rrr))
        movieList.add(Movie(4 , "KGF Chapter -2" , "Action" , 2022 , 5.0f , R.drawable.kgf_2))
        movieList.add(Movie(5 , "Dear Father" , "Comedy , Crime , Drama" ,2022 , 4.5f , R.drawable.dear_father))

    }
}