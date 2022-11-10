package com.example.recyclerviewextra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewextra.Adapter.RecyclerMovieAdapter
import com.example.recyclerviewextra.Model.Movie
import com.example.recyclerviewextra.databinding.ActivityRecyclerBinding
import com.example.recyclerviewextra.databinding.CustomImageDialogBinding
import com.example.recyclerviewextra.listner.OnMovieItemClickedListner

class RecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBinding
    private  var movieList = mutableListOf<Movie>()
    private lateinit var mAdapter: RecyclerMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding =  ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        prepareData()

        // pass data to adapter using constructor

        mAdapter = RecyclerMovieAdapter(this , movieList)

        var manager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = manager

        // set mAdapter to AdapterView
        binding.recyclerView.adapter =mAdapter


        mAdapter.setOnMovieItemClickedListner(object : OnMovieItemClickedListner{
            override fun onCardClicked(movie: Movie, pos: Int) {


                var intent = Intent(applicationContext, MovieDetailActivity::class.java)
                intent.putExtra("MOVIE" , movie)
                startActivity(intent)

            }

            override fun onImageClicked(movie: Movie) {

                showImageDialog(movie)

            }

        })
    }

    private fun showImageDialog(movie: Movie) {
        val binding = CustomImageDialogBinding.inflate(layoutInflater)
        var builder = AlertDialog.Builder(this)
        builder.setView(binding.root)

        binding.ivThubnail.setImageResource(movie.image)

        var dialog = builder.create()
        dialog.show()

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