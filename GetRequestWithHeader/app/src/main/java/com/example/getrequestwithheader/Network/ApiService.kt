package com.example.getrequestwithheader.Network

import com.example.getrequestwithheader.Model.City
import com.example.getrequestwithheader.Model.Country
import com.example.getrequestwithheader.Model.States
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {

    @Headers(
        "Accept : application/json",
        "Authorization : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJrZXZhbGRvbkBnbWFpbC5jb20iLCJhcGlfdG9rZW4iOiJ0cVI1RVJOOWh1U0Z3Mi1idERfU0RRUDZCbTU5LUxvWEpaWTE4STRVT1RhYnFjZEFpOEM4SF9uZzFFYS1VQVVxNmVzIn0sImV4cCI6MTY2NTY0OTQ3Mn0.Za9rPeb6Ka9uznXerIfBuC-YMe5vfc_8gx4LQwNoVHA"
    )
    @GET("countries")
    fun getCountry() : Call<List<Country>>

    @Headers(
        "Accept : application/json",
        "Authorization : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJrZXZhbGRvbkBnbWFpbC5jb20iLCJhcGlfdG9rZW4iOiJ0cVI1RVJOOWh1U0Z3Mi1idERfU0RRUDZCbTU5LUxvWEpaWTE4STRVT1RhYnFjZEFpOEM4SF9uZzFFYS1VQVVxNmVzIn0sImV4cCI6MTY2NTY0OTQ3Mn0.Za9rPeb6Ka9uznXerIfBuC-YMe5vfc_8gx4LQwNoVHA"
    )
    @GET("states/{con}")
    fun getState(@Path("con") country: String) : Call<List<States>>

    @Headers(
        "Accept : application/json",
        "Authorization : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJrZXZhbGRvbkBnbWFpbC5jb20iLCJhcGlfdG9rZW4iOiJ0cVI1RVJOOWh1U0Z3Mi1idERfU0RRUDZCbTU5LUxvWEpaWTE4STRVT1RhYnFjZEFpOEM4SF9uZzFFYS1VQVVxNmVzIn0sImV4cCI6MTY2NTY0OTQ3Mn0.Za9rPeb6Ka9uznXerIfBuC-YMe5vfc_8gx4LQwNoVHA"
    )
    @GET("cities/{sta}")
    fun getCity(@Path("sta") states: String) : Call<List<City>>

}
