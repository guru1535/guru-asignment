package com.example.internalstorage

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.internalstorage.databinding.ActivityMainBinding

class ExternalStorageActivity : AppCompatActivity() {
    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_storage)
        
        findViewById<Button>(R.id.btn_permission).setOnClickListener { 
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                // ask run time permission (api level above 23)
                if (ContextCompat.checkSelfPermission(this ,Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){
                    // PERMISSION  ALREADY GRANTED
                    Toast.makeText(applicationContext, "Permission Already Granted", Toast.LENGTH_SHORT).show()
                }else if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                    // show dialog
                    showAlert()

                } else{
                    // permission is denied so ask run time permission
                    requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),100)
                }
                
                
            }else{
                // // permission allowed(api level below 23)
                Toast.makeText(applicationContext, "Permission Allowed", Toast.LENGTH_SHORT).show()
                
            }
            
                
        }
        
    }

    private fun showAlert() {
        AlertDialog.Builder(this)
            .setTitle("Permission Required")
            .setMessage("for update your profile image you must have to allow storage permission")
            .setPositiveButton("Allow" , DialogInterface.OnClickListener { dialogInterface, i ->
                // navigate to app permission setting
                var intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                var uri = Uri.fromParts("package" , packageName , null)
                intent.data = uri
                startActivity(intent)


            }).setNegativeButton("Cancel" , DialogInterface.OnClickListener { dialogInterface, i ->

            }).show()
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
                    Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT).show()
                } else{
                    //permission denied 
                    Toast.makeText(applicationContext, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
          /*  200 ->{
                
            }*/
        }
    }
}