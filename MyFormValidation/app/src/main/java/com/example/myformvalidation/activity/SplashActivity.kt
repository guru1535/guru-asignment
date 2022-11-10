package com.example.myformvalidation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myformvalidation.R
import java.lang.Exception

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Thread(Runnable {

            try {
                Thread.sleep(3000)

                // navigate to login activity

                var intent = Intent(applicationContext , LoginActivity ::class.java)
                startActivity(intent)

            }catch (e : Exception){}
        }).start()
    }
}