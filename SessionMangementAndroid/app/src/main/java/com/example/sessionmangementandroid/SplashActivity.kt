package com.example.sessionmangementandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sessionmangementandroid.Prefrence.PrefManager
import com.example.sessionmangementandroid.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread(Runnable {

            Thread.sleep(3000)

            var manager = PrefManager(this)
            if (manager.getLoginStatus()){
                startActivity(Intent(applicationContext , HomeActivity::class.java))
            }else {
                startActivity(Intent(applicationContext , LoginActivity::class.java))
            }



        }).start()
    }
}