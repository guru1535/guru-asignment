package com.example.myinternalstorage

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat

class ExternalStorageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_storage)


        findViewById<Button>(R.id.btn_permission).setOnClickListener {

            askPermission()
        }
    }

    private fun askPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            // ask runtime permission (above api 23)
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){
                // permission is alredy granted
                Toast.makeText(applicationContext, "Permission Is Granted", Toast.LENGTH_SHORT).show()
            }else{
                // permission is denied so ask runtime permission
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),100)
            }
        }else{
            // permission is allowed
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
                    // permission granted
                    Toast.makeText(applicationContext, "Permission is Granted", Toast.LENGTH_SHORT).show()
                }else{
                    // permission is denied
                    Toast.makeText(applicationContext, "Permission is Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}