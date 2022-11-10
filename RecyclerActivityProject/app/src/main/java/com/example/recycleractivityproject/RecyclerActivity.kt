package com.example.recycleractivityproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleractivityproject.Adapter.RecyclerMovieAdapter
import com.example.recycleractivityproject.Adapter.RecyclerSeriesAdapter
import com.example.recycleractivityproject.Listner.OnMovieItemClickListner
import com.example.recycleractivityproject.Model.Movie
import com.example.recycleractivityproject.Model.Webseries
import com.example.recycleractivityproject.databinding.ActivityRecyclerBinding
import com.example.recycleractivityproject.databinding.CustomImageDialogBinding

class RecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBinding

    private var movieList = mutableListOf<Movie>()
    private var seriesList = mutableListOf<Webseries>()

    private lateinit var mAdapter : RecyclerMovieAdapter
    private lateinit var sAdapter :RecyclerSeriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        // Pass Data to Adapter Using Consructor (vertical)
        mAdapter = RecyclerMovieAdapter(this , movieList)

        var manager = LinearLayoutManager(applicationContext)                  //  by default ye vertical hota he
        binding.recyclerView.layoutManager = manager
        // set mAdapter to Adapter view
        binding.recyclerView.adapter = mAdapter

        // Pass Data to Adapter Using Consructor (Horizontal)
        this = RecyclerSeriesAdapter(this , seriesList)
        manager = LinearLayoutManager(this ,LinearLayoutManager.HORIZONTAL , false)
        binding.recyclerViewHorizontal.layoutManager = manager
        binding.recyclerViewHorizontal.adapter = this


        with(sAdapter) {
            binding.recyclerView.layoutManager = manager
            // set mAdapter to Adapter view
            binding.recyclerView.adapter = mAdapter

            // Pass Data to Adapter Using Consructor (Horizontal)
            this = RecyclerSeriesAdapter(this , seriesList)
            manager = LinearLayoutManager(this ,LinearLayoutManager.HORIZONTAL , false)
            binding.recyclerViewHorizontal.layoutManager = manager
            binding.recyclerViewHorizontal.adapter = this


            setOnSeriesItemClickedListner(object : OnMovieItemClickListner {
                override fun onCradClicked(movie: Any, pos: Int) {
                    TODO("Not yet implemented")
                }

                override fun onImageClicked(movie: Any) {
                    TODO("Not yet implemented")
                }


            }
                setOnMovieItemClickedListner(object : OnMovieItemClickListner{
                override fun onCradClicked(movie: Any, pos: Int) {

                    if (movie is Movie){
                        var intent = Intent(applicationContext ,MovieDetailActivity::class.java )
                        intent.putExtra("MOVIE" , movie)
                        startActivity(intent)
                    }

                }

                override fun onImageClicked(movie: Any) {
                    showImageDialog(movie as Movie)

                }



            })

        }


    }



    private fun showImageDialog(movie: Movie ) {

        val bind = CustomImageDialogBinding.inflate(layoutInflater)
        var builder = AlertDialog.Builder(this)
        builder.setView(bind.root)

        var dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
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


        seriesList.add(Webseries(1 ,"Love NI Bhavai" , R.drawable.love_ni_bhavai))
        seriesList.add(Webseries(2 ,"Pushpa The Rise" , R.drawable.puspa_the_rise))
        seriesList.add(Webseries(3 ,"R.R.R." , R.drawable.rrr))
        seriesList.add(Webseries(4 ,"KGF-2" , R.drawable.kgf_2))
        seriesList.add(Webseries(5 ,"Dear Father" , R.drawable.dear_father))

    }
}