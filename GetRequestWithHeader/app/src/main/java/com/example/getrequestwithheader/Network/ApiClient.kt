package com.example.getrequestwithheader.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{
        var retrofit : Retrofit? = null
        fun init() : ApiService{

            if (retrofit==null){
                retrofit = Retrofit.Builder()
                    .baseUrl(" https://www.universal-tutorial.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!.create(ApiService::class.java)
        }
    }
}