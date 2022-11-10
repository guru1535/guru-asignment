package com.example.androidadapterji

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidadapterji.Adapter.MovieAdapter
import com.example.androidadapterji.Model.Movie
import com.example.androidadapterji.databinding.ActivityCustomListBinding

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
        adapter = MovieAdapter(this , movieList)
        // set adapter to adapter view
        binding.listView.adapter = adapter

        // click event
        binding.listView.setOnItemClickListener { adapterView, view, pos, l ->

            var movie = movieList[pos]


            var intent = Intent(applicationContext , MovieDetailActivity ::class.java)
            intent.putExtra("MOVIE" , movie)
            startActivity(intent)

           // Toast.makeText(applicationContext , "${movie.title}" , Toast.LENGTH_SHORT).show()
        }
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


