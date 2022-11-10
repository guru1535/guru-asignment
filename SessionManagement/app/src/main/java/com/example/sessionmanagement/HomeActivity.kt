package com.example.sessionmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sessionmanagement.Preference.PrefManager
import com.example.sessionmanagement.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var manager = PrefManager(this)
        var array = manager.getUserDetail()

        array?.let {

            binding.tvUserDetail.text = """
                
                firstName : ${it[0]}
                lastName : ${it[1]}
                email : ${it[2]}
                contact : ${it[3]}
                
            """.trimIndent()


        }

        binding.btnLogout.setOnClickListener {

            manager.logout()

            startActivity(Intent(applicationContext , LoginActivity::class.java))
        }
    }
}