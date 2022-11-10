package com.example.nestedrecyclerviewextra.Model

data class Category(

    var id :Int,
    var title :String,
    var movieList: MutableList<SubCategory>
)
