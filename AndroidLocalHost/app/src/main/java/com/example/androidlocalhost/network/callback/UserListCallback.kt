package com.example.androidlocalhost.network.callback

import com.example.androidlocalhost.model.User
import com.google.gson.annotations.SerializedName

data class UserListCallback(

    @SerializedName("student")
    var userList: List<User>
)
