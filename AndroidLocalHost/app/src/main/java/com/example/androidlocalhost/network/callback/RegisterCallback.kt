package com.example.androidlocalhost.network.callback

import android.os.Message
import com.example.androidlocalhost.model.User

data class RegisterCallback(

    var status : String,
    var message: String,
    var user: User


)
