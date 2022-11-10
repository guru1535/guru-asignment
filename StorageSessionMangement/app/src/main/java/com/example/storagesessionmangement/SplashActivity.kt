package com.example.storagesessionmangement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storagesessionmangement.Prefrence.PrefManager
import com.example.storagesessionmangement.databinding.ActivitySplashBinding

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
                startActivity(Intent(applicationContext ,HomeActivity::class.java))
            }else{
                startActivity(Intent(applicationContext ,LoginActivity::class.java))

            }

        }).start()
    }
}