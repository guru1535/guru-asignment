package com.example.myprojectui.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myprojectui.R
import java.lang.Exception
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Thread(Runnable {

           try {
               Thread.sleep(3000)

               // Navigate to login activity

               var intent = Intent(this , LoginActivity::class.java)
               startActivity(intent)

           }catch (e:Exception){}

        }).start()
    }

}