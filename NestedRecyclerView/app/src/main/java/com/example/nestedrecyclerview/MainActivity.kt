package com.example.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclerview.Adapter.CategoryAdapter
import com.example.nestedrecyclerview.Model.Category
import com.example.nestedrecyclerview.Model.SubCategory
import com.example.nestedrecyclerview.databinding.ActivityMainBinding

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
                Toast.makeText(applicationContext, "$title : $position", Toast.LENGTH_SHORT).show()
            }

            override fun onChildItemClicked(view: View, subCategory: SubCategory) {
                view.setBackgroundColor(ContextCompat.getColor(applicationContext ,R.color.teal_200))
                Toast.makeText(applicationContext, "${subCategory.name} :${subCategory.id}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun prepareData() {

        var movieList = mutableListOf<SubCategory>()
        movieList.add(SubCategory(1 ,"Love NI Bhavai" , R.drawable.love_ni_bhavai ))
        movieList.add(SubCategory(2 ,"Pushpa" , R.drawable.puspa_the_rise ))
        movieList.add(SubCategory(3 ,"R.R.R." , R.drawable.rrr))
        movieList.add(SubCategory(4 ,"KGF-2" , R.drawable.kgf_2))
        movieList.add(SubCategory(5 ,"Dear Father" , R.drawable.dear_father ))

        categoryList = mutableListOf()
        categoryList.add(Category(1 , "Top 10 Movies" , movieList))
        categoryList.add(Category(2 , "Recently Added" , movieList))
        categoryList.add(Category(3 , "Action Movie" , movieList))
        categoryList.add(Category(4 , "Horror Movie" , movieList))

    }
}