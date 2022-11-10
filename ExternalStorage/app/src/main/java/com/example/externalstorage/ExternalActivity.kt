package com.example.externalstorage

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ExternalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external)


        findViewById<Button>(R.id.btn_permission).setOnClickListener {

            askPermission()

        }
    }

    private fun askPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            // ask run  time permission (API level is above 23 )

            if (ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED){

                // permission is already granted
                // hear apne agal ni process no code write kari shkiye chie
                Toast.makeText(applicationContext, "Permission is granted", Toast.LENGTH_SHORT).show()

            }else{
                // permission denied so ask run time permission
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE) , 100)
            }

        }else{
            // don't required ask run permission because all device are below marsh mellow(API level is below 23)
            Toast.makeText(applicationContext, "Permission Allowed", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        
        when(requestCode){
            100 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                    //permission granted
                    Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT).show()
                }else{
                    //permission denied
                    Toast.makeText(applicationContext, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}