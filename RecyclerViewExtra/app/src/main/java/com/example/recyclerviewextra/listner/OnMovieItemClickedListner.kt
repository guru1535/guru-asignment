package com.example.recyclerviewextra.listner

import android.view.View
import com.example.recyclerviewextra.Model.Movie

interface OnMovieItemClickedListner {

    fun onCardClicked(movie: Movie , pos :Int )
    fun onImageClicked(movie: Movie)

}