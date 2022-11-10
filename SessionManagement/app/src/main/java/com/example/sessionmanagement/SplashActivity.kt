package com.example.sessionmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sessionmanagement.Preference.PrefManager
import com.example.sessionmanagement.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Thread(Runnable {

            Thread.sleep(3000)

            var manager = PrefManager(this)

            if (manager.getLoginStatus()){

                startActivity(Intent(applicationContext , HomeActivity::class.java))       //navigate to Home
            }else{

                startActivity(Intent(applicationContext , LoginActivity::class.java))       //navigate to Login
            }



        }).start()
    }
}