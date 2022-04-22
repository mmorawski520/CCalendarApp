package com.example.ccalendarapp

import android.app.DatePickerDialog
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.SeekBar
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    var dateFormatString = "MM/dd/yyyy"
    var dateFormat = SimpleDateFormat(dateFormatString, Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val cal = Calendar.getInstance()

        //layout components
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val stepTextView = findViewById<TextView>(R.id.textViewStep)

        //btns
        val btnJourneyStart = findViewById<Button>(R.id.btnJourneyStart)
        val btnJourneyMid = findViewById<Button>(R.id.btnJourneyMiddle)
        val btnJourneyEnd = findViewById<Button>(R.id.btnJourneyEnd)
        val btnSimulate = findViewById<Button>(R.id.btnStartSim)

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            }
        }

        btnJourneyStart.setOnClickListener {
            var dpd = DatePickerDialog(
                this@MainActivity,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            )
            val currentDate = Calendar.getInstance()
            currentDate.set(currentDate.get(Calendar.YEAR), Calendar.DECEMBER, 31)
            dpd.datePicker.minDate = Date().time
            dpd.datePicker.setMaxDate(currentDate.timeInMillis)
            dpd.show()
            btnJourneyStart.text = dateFormat.format(cal.getTime())
        }

        btnJourneyMid.setOnClickListener {
            var dpd = DatePickerDialog(
                this@MainActivity,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            )
            val currentDate = Calendar.getInstance()
            currentDate.set(currentDate.get(Calendar.YEAR), Calendar.DECEMBER, 31)
            dpd.datePicker.minDate = Date().time
            dpd.datePicker.setMaxDate(currentDate.timeInMillis)
            dpd.show()
            btnJourneyMid.text = dateFormat.format(cal.getTime())
        }
        btnJourneyEnd.setOnClickListener {
            var dpd = DatePickerDialog(
                this@MainActivity,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            )
            val currentDate = Calendar.getInstance()
            currentDate.set(currentDate.get(Calendar.YEAR), Calendar.DECEMBER, 31)
            dpd.datePicker.minDate = Date().time
            dpd.datePicker.setMaxDate(currentDate.timeInMillis)
            dpd.show()
            btnJourneyEnd.text = dateFormat.format(cal.getTime())
        }
        btnSimulate.setOnClickListener {
            var SimulationData: SimulationDates =
                SimulationDates(
                    dateFormat.parse(btnJourneyStart.text.toString()),
                    dateFormat.parse(btnJourneyMid.text.toString()),
                    dateFormat.parse(btnJourneyEnd.text.toString()),
                    stepTextView.text.toString().toDouble()
                );
            val intent = Intent(this, SimulationActivity::class.java)
            // intent.putExtra("SimulationData",SimulationData)
            intent.putExtra("SimulationData",SimulationData)
            startActivity(intent)
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            var progressChangedValue = 0
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                progressChangedValue = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                stepTextView.text = (progressChangedValue.toDouble() / 10).toString();
            }
        })
    }
}