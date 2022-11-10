package com.example.recycleractivityproject.Listner

import com.example.recycleractivityproject.Model.Movie

interface OnMovieItemClickListner {

    fun onCradClicked(movie: Any , pos : Int)
    fun onImageClicked(movie: Any )
    infix fun setOnMovieItemClickedListner(onMovieItemClickListner: OnMovieItemClickListner): OnMovieItemClickListner {

    }
}