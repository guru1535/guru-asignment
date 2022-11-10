package com.example.androidlocalhost.network

import com.example.androidlocalhost.network.callback.RegisterCallback
import com.example.androidlocalhost.network.callback.UserListCallback
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("student.php")
    fun register(
        @Field("flag") flag :Int,
        @Field("name") name : String,
        @Field("email") email : String,
        @Field("mobile") contact :String) : Call<RegisterCallback>

    @GET("student.php")
    fun getUserList(@Query("flag") flag: Int) : Call<UserListCallback>
}