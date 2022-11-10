package com.example.bottomnavigationextra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigationextra.Fragment.*
import com.example.bottomnavigationextra.databinding.ActivityBottomNavigationBinding

class BottomNavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        addFragment(HomeFragment() , "Home")

        binding.bottomNavigation.setOnItemSelectedListener {
            return@setOnItemSelectedListener when(it.itemId){

                R.id.action_home ->{

                    addFragment(HomeFragment() , "Home")

                    true
                } R.id.action_search ->{
                    addFragment(SearchFragment() , "Search")
                    true
                } R.id.action_cart ->{

                    addFragment(CartFragment() , "Cart")
                    true
                } R.id.action_notification ->{

                    addFragment(NotificationFragment() , "Notification")
                    true
                } R.id.action_profile ->{

                    addFragment(ProfileFragment() , "Profile")
                    true
                }else -> false
            }
        }
    }

    private fun addFragment(fragment: Fragment, tag: String) {

        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container , fragment ,tag)
        transaction.commit()
        transaction.addToBackStack(null)

        binding.toolbar.title = tag

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}