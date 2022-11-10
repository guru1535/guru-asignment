package com.example.retrofitgetrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitgetrequest.Adapter.UserListAdapter
import com.example.retrofitgetrequest.HttpRequest.ApiService
import com.example.retrofitgetrequest.Model.User
import com.example.retrofitgetrequest.Model.UserResponse
import com.example.retrofitgetrequest.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var userList = mutableListOf<User>()
    lateinit var mAdapter: UserListAdapter
    lateinit var retrofit: Retrofit
    lateinit var apiService: ApiService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)

      //  userList.add(User(1 , "keval@gmail.com" , "keval"  , "Mangukiya" , ""))
      //  userList.add(User(2 , "keeval@gmail.com" , "keeval"  , "Maangukiya" , ""))

        mAdapter = UserListAdapter(this , userList)
        binding.recyclerItem.layoutManager = LinearLayoutManager(this)
        binding.recyclerItem.adapter = mAdapter

        loadUserList()

    }

    private fun loadUserList() {

        binding.progressCircular.visibility = View.VISIBLE
        var callback = apiService.getUserList()
        callback.enqueue(object :  Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                // For Success
                binding.progressCircular.visibility = View.GONE
                if (response.isSuccessful){
                    var res = response.body()
                    res?.let {

                        userList = it.userList
                        mAdapter.setItem(userList)
                    }
                }

            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                // For Failure
                binding.progressCircular.visibility = View.GONE
                Toast.makeText(applicationContext, "${t.message}" , Toast.LENGTH_SHORT).show()
            }

        })
    }
}