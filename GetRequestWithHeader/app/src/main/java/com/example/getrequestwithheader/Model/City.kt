package com.example.getrequestwithheader.Model

import com.google.gson.annotations.SerializedName

data class City(

    @SerializedName("city_name")
    var cityName : String
){
    override fun toString(): String {
        return cityName
    }
}
