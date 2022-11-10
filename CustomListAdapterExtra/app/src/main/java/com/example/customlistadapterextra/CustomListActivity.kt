package com.example.customlistadapterextra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.customlistadapterextra.Adapter.MovieAdapter
import com.example.customlistadapterextra.Model.Movie
import com.example.customlistadapterextra.databinding.ActivityCustomListBinding

class CustomListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomListBinding

    private var movieList = mutableListOf<Movie>()

    lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityCustomListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        // pass data to adapter using constructor
        adapter = MovieAdapter(this ,movieList)
        // set adapter to adapter view
        binding.listView.adapter = adapter
        // click event of CustomListAdapter

        binding.listView.setOnItemClickListener { adapterView, view, pos, l ->

           var movie = movieList[pos]

            intent = Intent(applicationContext , MovieDetailActivity::class.java)
            intent.putExtra("MOVIE" , movie)
            startActivity(intent)

           //Toast.makeText(applicationContext  , "${movie.title}", Toast.LENGTH_SHORT).show()
       }


    }

    private fun prepareData() {
        movieList.add(Movie(1 , "Love Ni Bhavai" , "Romantic Drama" , 4.5f , 2017  , R.drawable.love_ni_bhavai))
        movieList.add(Movie(2 , "Pushpa The Rise" , "Action , Drama" , 4.8f , 2021 , R.drawable.puspa_the_rise))
        movieList.add(Movie(3,"R.R.R." , "Action , Drama" , 4.7f , 2022 , R.drawable.rrr))
        movieList.add(Movie(4 , "K.G.F. : Chapter - 2" ,"Fully Action" , 4.9f , 2022 , R.drawable.kgf_2))
        movieList.add(Movie(5 , "Dear Father" , "Comedy , Crime , Drama" , 5.0f , 2022 , R.drawable.dear_father))
    }
}