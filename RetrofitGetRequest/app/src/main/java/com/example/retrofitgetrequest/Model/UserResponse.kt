package com.example.retrofitgetrequest.Model

import com.google.gson.annotations.SerializedName

data class UserResponse(

    var page :Int,
    @SerializedName("per_page")
    var perPage : Int,
    var total : Int,
    @SerializedName("total_pages")
    var totalPage : Int,
    var support: Support,
    @SerializedName("data")
    var userList: MutableList<User>
)
