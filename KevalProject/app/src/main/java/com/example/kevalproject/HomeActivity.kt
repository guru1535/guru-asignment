package com.example.kevalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.kevalproject.Adapter.ItemListAdapter
import com.example.kevalproject.Model.Item
import com.example.kevalproject.Preference.PrefManager
import com.example.kevalproject.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private  var itemList = mutableListOf<Item>()
   private lateinit var adapter: ItemListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        // pass data to adapter using constuctor
        adapter = ItemListAdapter(this , itemList)
        // set Adapter to adapterview
        binding.listView.adapter = adapter

    }

    private fun prepareData() {
        itemList.add(Item(1 , "Devloper No 1" , R.drawable.programing_boy_1))
        itemList.add(Item(1 , "Devloper No 2" , R.drawable.programing_boy_2))
        itemList.add(Item(1 , "Devloper No 3" , R.drawable.programing_boy_3))
        itemList.add(Item(1 , "Devloper No 4" , R.drawable.programing_boy_4))
        itemList.add(Item(1 , "Devloper No 5" , R.drawable.programing_boy_5))
        itemList.add(Item(1 , "Devloper No 6" , R.drawable.programing_boy_7))
        itemList.add(Item(1 , "Devloper No 7" , R.drawable.programing_boy_8))
        itemList.add(Item(1 , "Devloper No 8" , R.drawable.programing_boy_10))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu , menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_logout ->{
                var manager = PrefManager(this)
                manager.logout()
                startActivity(Intent(applicationContext , LoginActivity::class.java))
                true
            }else -> super.onOptionsItemSelected(item)
        }

    }
}

