package com.example.androidassessment2022.Activity

import android.app.VoiceInteractor
import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidassessment2022.Activity.Adapter.OptionItemAdapter
import com.example.androidassessment2022.Activity.Model.Option
import com.example.androidassessment2022.Activity.Preference.PrefManager
import com.example.androidassessment2022.R
import com.example.androidassessment2022.databinding.ActivityDashBoardBinding
import java.security.cert.PKIXRevocationChecker

class DashBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashBoardBinding
    var optionList = mutableListOf<Option>()
    lateinit var oAdapter : OptionItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        optionData()

        oAdapter = OptionItemAdapter(this , optionList)
        binding.recyclerView.layoutManager = GridLayoutManager(this , 1)
        binding.recyclerView.adapter = oAdapter

    }

    private fun optionData() {

        optionList.add(Option(1 , "Play Quiz"))
        optionList.add(Option(2 , "Read Questions"))
    }


    // Option menu showing work start
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_about -> {
                // navigate to action about activity or show dialog
                true
            }
            R.id.action_contact ->{
                // navigate to action contact activity or show dialog
                true
            }
            R.id.action_logout -> {
                // navigate to action login activity
                var manager = PrefManager(this)
                manager.logOut()
                startActivity(Intent(applicationContext , LoginActivity::class.java))


                true
            }else -> super.onOptionsItemSelected(item)
        }
    } // option menu work ending
}