 package com.example.androidmenuanddialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

 class MainActivity : AppCompatActivity() {

     val btnContext : Button
     get() = findViewById(R.id.btn_context)

     val btnPopup : Button
     get() = findViewById(R.id.btn_popup)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(btnContext)



        btnPopup.setOnClickListener {

            var popupMenu = PopupMenu(this , it)
            menuInflater.inflate(R.menu.action_menu , popupMenu.menu)
            popupMenu.show()

            popupMenu.setOnMenuItemClickListener {
                return@setOnMenuItemClickListener when(it.itemId){
                    R.id.action_search -> {
                        Toast.makeText(applicationContext , " Popup :Search item selected" , Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.action_settings -> {
                        Toast.makeText(applicationContext , "Popup  : Settings item selected" , Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.action_logout -> {
                        Toast.makeText(applicationContext , " Popup :Logout item selected" , Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false
                }

            }
        }
    }



     // option menu


 override fun onCreateOptionsMenu(menu: Menu?): Boolean {
     menuInflater.inflate(R.menu.action_menu, menu)

     return true
 }


     override fun onOptionsItemSelected(item: MenuItem): Boolean {

         return when(item.itemId){
             R.id.action_search -> {
                 Toast.makeText(applicationContext , "Search item selected" , Toast.LENGTH_SHORT).show()
                 true
             }

             R.id.action_settings -> {
                 Toast.makeText(applicationContext , "Settings item selected" , Toast.LENGTH_SHORT).show()
                 true
             }

             R.id.action_logout -> {
                 Toast.makeText(applicationContext , "Logout item selected" , Toast.LENGTH_SHORT).show()
                 true
             }

             else -> super.onOptionsItemSelected(item)
         }

     }
        // context menu


     override fun onCreateContextMenu(

         menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
         super.onCreateContextMenu(menu, v, menuInfo)

         menuInflater.inflate(R.menu.action_menu , menu)


     }

     override fun onContextItemSelected(item: MenuItem): Boolean {

         return when(item.itemId){
             R.id.action_search -> {
                 Toast.makeText(applicationContext , "Context : Search item selected" , Toast.LENGTH_SHORT).show()
                 true
             }

             R.id.action_settings -> {
                 Toast.makeText(applicationContext , "Context : Settings item selected" , Toast.LENGTH_SHORT).show()
                 true
             }

             R.id.action_logout -> {
                 Toast.makeText(applicationContext , "Context : Logout item selected" , Toast.LENGTH_SHORT).show()
                 true
             }

             else -> super.onContextItemSelected(item)
     }


 }



}