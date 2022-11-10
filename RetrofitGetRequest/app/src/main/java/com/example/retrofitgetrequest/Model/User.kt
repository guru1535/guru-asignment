package com.example.retrofitgetrequest.Model

import com.google.gson.annotations.SerializedName

data class User(

    var id  :Int,
    var email :String,
    @SerializedName("first_name")
    var fName :String,
    @SerializedName("last_name")
    var lName : String,
    @SerializedName("avatar")
    var profileUrl : String
)
