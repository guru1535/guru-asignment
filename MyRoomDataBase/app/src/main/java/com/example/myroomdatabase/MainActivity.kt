package com.example.myroomdatabase

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.myroomdatabase.Adapter.RecyclerUserAdapter
import com.example.myroomdatabase.Database.AppDatabase
import com.example.myroomdatabase.Database.Entity.User
import com.example.myroomdatabase.databinding.ActivityMainBinding
import com.example.myroomdatabase.databinding.ItemDialogLayoutBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var db : AppDatabase
    var userList = mutableListOf<User>()
    lateinit var mAdapter: RecyclerUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = Room.databaseBuilder(this , AppDatabase::class.java , "tops-user.db").allowMainThreadQueries().build()

        mAdapter = RecyclerUserAdapter(this , userList)
        var manager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = manager
        binding.recyclerView.adapter = mAdapter

        updateList()

        mAdapter.setOnListItemClickListner(object :RecyclerUserAdapter.OnListItemClickListner {
            override fun onDeleteItemClicked(user: User) {
                showDeleteDialog(user)
            }

            override fun onUpdateItemClicked(user: User) {
                showUpdateDialog(user)
            }

        })






        binding.btnSave.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()

            insertRecord(name , email)
        }
    }

    private fun showUpdateDialog(user: User) {
        var bind = ItemDialogLayoutBinding.inflate(layoutInflater)

        var builder = AlertDialog.Builder(this)
            .setView(bind.root)

        bind.etName.setText(user.name)
        bind.etEmail.setText(user.email)

        var alert = builder.create()
        alert.show()


        bind.btnUpdate.setOnClickListener {
            var name = bind.etName.text.toString().trim()
            var email = bind.etEmail.text.toString().trim()

            var mUser = User(id = user.id , name = name , email = email)

            db.UserDao().updateRecord(mUser)
            updateList()
            alert.dismiss()


        }

    }

    private fun showDeleteDialog(user: User) {
        AlertDialog.Builder(this)
            .setTitle("Delete Record")
            .setMessage("Are you sure you want to delete this item")
            .setPositiveButton("Delete" , DialogInterface.OnClickListener { dialogInterface, i ->
                db.UserDao().deleteRecord(user)
                updateList()

            }).setNegativeButton("Cancel" , DialogInterface.OnClickListener { dialogInterface, i ->

            }).show()

    }

    private fun insertRecord(name: String, email: String) {

        var user =User(name = name , email = email)
        db.UserDao().insertRecord(user)

        Toast.makeText(applicationContext, "Record Added", Toast.LENGTH_SHORT).show()

        updateList()

    }

    private fun updateList() {
        var list = db.UserDao().getAllRecord() as MutableList<User>
        mAdapter.setItem(list)
    }


}