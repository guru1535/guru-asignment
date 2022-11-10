package com.example.getrequestwithheader.Model

import com.google.gson.annotations.SerializedName

data class States(

    @SerializedName("state_name")
    var stateName : String
){
    override fun toString(): String {
        return stateName
    }
}
