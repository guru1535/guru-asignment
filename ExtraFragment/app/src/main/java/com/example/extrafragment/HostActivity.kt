package com.example.extrafragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.extrafragment.databinding.ActivityHostBinding

class HostActivity : AppCompatActivity() , ThirdFragment.Communicator {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)



    }

    override fun setValue(name: String, message: String) {

        var fragment = supportFragmentManager.findFragmentById(R.id.fragment_fourth)

        if (fragment is FourthFragment){
            fragment.updateResult(name, message)
        }
    }
}