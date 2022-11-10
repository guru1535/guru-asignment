package com.example.myandroidmenuanddialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myandroidmenuanddialog.databinding.ActivityDialogBinding
import com.example.myandroidmenuanddialog.databinding.CustomDialogLayoutBinding
import java.text.DecimalFormat
import java.util.*


class DialogActivity : AppCompatActivity() {

    lateinit var binding: ActivityDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Time Picker Dialog

        binding.ivTimePicker.setOnClickListener {

            var currentTime = Calendar.getInstance()
            var hours = currentTime.get(Calendar.HOUR)
            var minuts = currentTime.get(Calendar.MINUTE)

          var timePicker =  TimePickerDialog(this , TimePickerDialog.OnTimeSetListener { timePicker, mHours, mMinuts ->

                var timeFormatter = DecimalFormat("00")



                var hours = timeFormatter.format( if(mHours == 0){12}else{mHours} )
                var minuts = timeFormatter.format(mMinuts)



                var time = "${hours} : ${minuts}"
                binding.etTime.setText(time)

            },hours,minuts,true)
            timePicker.show()

        }


        binding.ivTimePicker1.setOnClickListener {

            var currentTime = Calendar.getInstance()
            var hours = currentTime.get(Calendar.HOUR)
            var minuts = currentTime.get(Calendar.MINUTE)


            var timePicker=TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { timePicker,hoursData, mints ->

                var timeSet=""

                if(hoursData>12){
                    hours -=12
                    timeSet="Pm"
                }
                //print 12 hours
                else if(hoursData==0){
                    //hours=12
                    hours +=12
                    timeSet ="Am"
                }
                else if(hoursData==12){
                    timeSet="Pm"
                }
                else{
                   // hours
                   timeSet="Am"
                }

                var min=""

                if(mints < 10){
                  min= "0" + mints
                }
                else{
                 min=mints.toString()
                }

                val TimeData: String = StringBuilder().append(hoursData).append(':')
                    .append(min).append(" ").append(timeSet).toString()

                binding.etTime12Hourse.setText(TimeData)

            },hours,minuts,false)

            timePicker.show()
        }


        //  DATE PICKER DIALOG

        binding.ivDatePicker.setOnClickListener {

            var calender = Calendar.getInstance()
            var year = calender.get(Calendar.YEAR)
            var month = calender.get(Calendar.MONTH)
            var day = calender.get(Calendar.DAY_OF_MONTH)


           var datePicker = DatePickerDialog(this , DatePickerDialog.OnDateSetListener { datePicker, mYear, mMonth, mDayOfMonth ->

               var formatter = DecimalFormat("00")

               var dayOfMonth = formatter.format(mDayOfMonth)
               var month = formatter.format(mMonth+1)

                var date = "$dayOfMonth/$month/$mYear"
                binding.etDob.setText(date)

            },year,month,day)
            datePicker.show()







        }
    }



    fun onButtonClicked(view: View) {

      //  showAlertDialog()

        when(view.id){
            R.id.btn_dialog -> showAlertDialog()
            R.id.btn_dialog_single -> showSingleChoiceDialog()
            R.id.btn_dialog_multi -> showMultiChoiceDialog()
            R.id.btn_dialog_custom-> showCustomDialog()
        }


    }

    private fun showCustomDialog() {
        var bind = CustomDialogLayoutBinding.inflate(layoutInflater)
        var builder:AlertDialog.Builder = AlertDialog.Builder(this)
            .setView(bind.root)

        val dialog = builder.create()
        dialog.show()
        bind.btnOk.setOnClickListener {

            Toast.makeText(applicationContext , "Ok Button Clicked" , Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
    }

    private fun showMultiChoiceDialog() {

        var checkedList = mutableListOf<String>()
        var langArray = resources.getStringArray(R.array.languages)

        var builder:AlertDialog.Builder = AlertDialog.Builder(this)
            .setTitle("Selected langauges")
            .setMultiChoiceItems(langArray , null , { dialogInterface, position, isChecked->

                var language = langArray[position]

                if (isChecked) {
                    checkedList.add(language)
                }else{
                    checkedList.remove(language)
                }

                Toast.makeText(applicationContext , "$checkedList" , Toast.LENGTH_SHORT).show()
            })

        builder.show()
    }

    private fun showSingleChoiceDialog() {

        var colorArray = arrayOf("Red" , "Green" , "Blue" , "White","Black", "Orange")

        // Traditional Single Choice

      /*  var builder : AlertDialog.Builder = AlertDialog.Builder(this)
            .setTitle("Pick color")
            .setItems(colorArray , DialogInterface.OnClickListener { dialogInterface, i ->

                var color =  colorArray[i]
                binding.tvResult.text = color
               // Toast.makeText(applicationContext , "$color" , Toast.LENGTH_SHORT).show()

            })


        builder.show()*/

        var selectedColor = colorArray[2]

        var builder : AlertDialog.Builder =AlertDialog.Builder(this)
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
            .setMessage("Are you sure you want to delete this item ?")
            .setPositiveButton("delete" , DialogInterface.OnClickListener { dialogInterface, i ->
                // delete button click event
                Toast.makeText(applicationContext , "delete button clicked" , Toast.LENGTH_SHORT).show()
            }).setNegativeButton("cancel" , DialogInterface.OnClickListener { dialogInterface, i ->
                // cancel button click event
                Toast.makeText(applicationContext , "cancel button clicked" , Toast.LENGTH_SHORT).show()

            }).setNeutralButton("Do later" , DialogInterface.OnClickListener { dialogInterface, i ->
                // do later
            })
        builder.show()

    }


    fun Set12Hours( hours:Int, mins:Int){


    }
}