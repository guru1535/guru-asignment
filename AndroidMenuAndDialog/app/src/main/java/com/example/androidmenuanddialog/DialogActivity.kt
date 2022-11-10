package com.example.androidmenuanddialog

import android.app.DatePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.androidmenuanddialog.databinding.ActivityDialogBinding
import com.example.androidmenuanddialog.databinding.CustomDialogLayoutBinding
import java.text.DecimalFormat
import java.util.*

class DialogActivity : AppCompatActivity() {
    lateinit var binding: ActivityDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ivDatePicker.setOnClickListener {

          var calender = Calendar.getInstance()
          var year = calender.get(Calendar.YEAR)
          var month = calender.get(Calendar.MONTH)
          var day = calender.get(Calendar.DAY_OF_MONTH)

          var datePicker = DatePickerDialog(this , DatePickerDialog.OnDateSetListener { datePicker, mYear, mMonth, mDayOfMonth ->

              var formatter = DecimalFormat("00")

              var dayOfMonth = formatter.format(mDayOfMonth)
              var month = formatter.format(mMonth+1)

              var date = "$dayOfMonth/${month}/$mYear"
              binding.etDob.setText(date)

          },year , month , day)
            datePicker.show()
        }


    }

    fun onButtonClicked(view: View) {

        //showAlertDialog()
        when(view.id){

            R.id.btn_dialog -> showAlertDialog()
            R.id.btn_dialog_single -> showSingleChoiceDialog()
            R.id.btn_dialog_multi -> showMultiChoiceDialog()
            R.id.btn_dialog_custom -> showCustomDialog()
        }

    }

    private fun showCustomDialog() {

        var bind = CustomDialogLayoutBinding.inflate(layoutInflater)

        var builder : AlertDialog.Builder = AlertDialog.Builder(this)
            .setView(bind.root)

        val dialog = builder.create()
        dialog.show()

        bind.btnOk.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(applicationContext , "Ok Button Clicked" , Toast.LENGTH_SHORT).show()
        }

           // .setView(LayoutInflater.from(this).inflate(R.layout.custom_dialog_layout , null))


    }

    // multi choice checkbox
    private fun showMultiChoiceDialog() {
        var checkedList = mutableListOf<String>()
        var langArray = resources.getStringArray(R.array.languages)
        var builder:AlertDialog.Builder = AlertDialog.Builder(this)
            .setTitle("Selected Language ")
            .setMultiChoiceItems(langArray , null ,  { dialogInterface, position, isChecked ->

                var language = langArray[position]

                if (isChecked){
                    checkedList.add(language)
                }else{
                    checkedList.remove(language)
                }

                Toast.makeText(applicationContext , "$checkedList" , Toast.LENGTH_SHORT).show()
            })
        builder.show()
    }




    private fun showSingleChoiceDialog() {
        var colorArray = arrayOf("Green" , "Blue" , "Black" , "White" , "Yellow" , "Red" , "Orange")
        // traditional single choice
      /*  var builder : AlertDialog.Builder = AlertDialog.Builder(this)
            .setTitle("Pick color")
            .setItems(colorArray , DialogInterface.OnClickListener { dialogInterface, i ->
                    var color = colorArray[i]
                    binding.tvResult.text = color
               // Toast.makeText(applicationContext , "$color" , Toast.LENGTH_SHORT).show()
            })
        builder.show()*/

        // redio button single choice

        var selectedColor = colorArray[2]

        var builder: AlertDialog.Builder = AlertDialog.Builder(this)
            .setTitle("Pick color")
            .setSingleChoiceItems(colorArray , 2 , DialogInterface.OnClickListener { dialogInterface, i ->

                selectedColor = colorArray[i]
            }).setPositiveButton("Done" , DialogInterface.OnClickListener { dialogInterface, i ->
                binding.tvResult.text = selectedColor
            })
        builder.show()

    }

    private fun showAlertDialog() {
        var builder : AlertDialog.Builder = AlertDialog.Builder(this)
            .setTitle("Alert")
            .setMessage("Are you sure you want to delete this item")
            .setPositiveButton("Delete" , DialogInterface.OnClickListener { dialogInterface, i ->
                // delete button cliked event
                Toast.makeText(applicationContext , "Delete this item" , Toast.LENGTH_SHORT).show()
            }).setNegativeButton("cancel" , DialogInterface.OnClickListener { dialogInterface, i ->
                // cancel button clicked event
                Toast.makeText(applicationContext , "Cancel this item" , Toast.LENGTH_SHORT).show()
            }).setNeutralButton("Do later" , DialogInterface.OnClickListener { dialogInterface, i ->

            })
        builder.show()

    }

}