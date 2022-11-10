package com.example.retrofitgetrequest.HttpRequest

import com.example.retrofitgetrequest.Model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {


    @GET(value = "users?page=2")
    fun getUserList() : Call<UserResponse>

}