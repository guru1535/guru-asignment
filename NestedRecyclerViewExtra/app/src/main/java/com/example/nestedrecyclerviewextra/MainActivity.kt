package com.example.nestedrecyclerviewextra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclerviewextra.Adapter.CategoryAdapter
import com.example.nestedrecyclerviewextra.Model.Category
import com.example.nestedrecyclerviewextra.Model.SubCategory
import com.example.nestedrecyclerviewextra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var categoryList: MutableList<Category>
    lateinit var parentAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        parentAdapter = CategoryAdapter(this , categoryList)
        binding.parentView.layoutManager = LinearLayoutManager(this)
        binding.parentView.adapter = parentAdapter

        parentAdapter.setOnItemClickListner(object : CategoryAdapter.ItemClickListner {
            override fun viewAllClicked(id: Int, position: Int, title: String) {
                Toast.makeText(applicationContext, "$title :$position", Toast.LENGTH_SHORT).show()
            }

            override fun onChildItemClicked(view: View, subCategory: SubCategory) {
                Toast.makeText(applicationContext, "${subCategory.name} : ${subCategory.id}", Toast.LENGTH_SHORT).show()
            }

        })
        }
    }

    private fun prepareData() {

        var movieList = mutableListOf<SubCategory>()
        movieList.add(SubCategory(1 , "Love Ni Bhavai" , R.drawable.love_ni_bhavai))
        movieList.add(SubCategory(2 , "Pushpa" , R.drawable.puspa_the_rise))
        movieList.add(SubCategory(3 , "R.R.R." , R.drawable.rrr))
        movieList.add(SubCategory(4 , "KGF - 2" , R.drawable.kgf_2))
        movieList.add(SubCategory(5 , "Dear Father" , R.drawable.dear_father))


        var caegoryList = mutableListOf<Category>()

        caegoryList.add(Category(1 , "Top 10 Movies" ,movieList ))
        caegoryList.add(Category(2 , "Recently Added" ,movieList ))
        caegoryList.add(Category(3 , "Action Movies" ,movieList ))
        caegoryList.add(Category(4 , "Horror Movies" ,movieList ))
    }
