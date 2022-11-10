package com.example.androidlocalhost.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiClient {

    companion object{
        var retrofit : Retrofit? = null
        fun init() : ApiService{

            if (retrofit==null){
                retrofit =Retrofit.Builder()
                    .baseUrl("http://192.168.43.18/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!.create(ApiService::class.java)
        }
    }
}