package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import java.text.SimpleDateFormat

import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.btnpop)


btn.setOnClickListener { view->calender1(view)

}


    }
    fun calender1(view: View){
        val c=Calendar.getInstance();
        val year=c.get(Calendar.YEAR);
        val month=c.get(Calendar.MONTH);
        val day=c.get(Calendar.DAY_OF_MONTH);
        val textview=findViewById<TextView>(R.id.textView2)
        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"



                textview.setText(selectedDate)


                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)


                val selectedDateToMinutes = theDate!!.time / 60000


                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateToMinutes = currentDate!!.time / 60000


                val differenceInMinutes = currentDateToMinutes - selectedDateToMinutes


                textview.setText(differenceInMinutes.toString())
            },
            year,
            month,
            day
        )



        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show() // It is used to show the datePicker Dialog.
    }
}



