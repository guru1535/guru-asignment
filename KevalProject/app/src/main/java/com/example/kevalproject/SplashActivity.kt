package com.example.kevalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kevalproject.Preference.PrefManager
import java.lang.Exception

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Thread(Runnable {

            try {

                Thread.sleep(3000)

                var manager = PrefManager(this)

                if (manager.getLoginStatus()){
                    // navigate to home
                    startActivity(Intent(applicationContext ,HomeActivity::class.java ))
                    finish()
                }else{
                    // navigate to on boarding
                    startActivity(Intent(applicationContext ,OnBoardingScreenActivity::class.java ))
                    finish()
                }


            }catch (e : Exception){}
        }).start()
    }
}