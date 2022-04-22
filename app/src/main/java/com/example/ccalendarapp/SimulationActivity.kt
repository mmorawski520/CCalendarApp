package com.example.ccalendarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.ProgressBar

class SimulationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulation)

        val progress = findViewById<ProgressBar>(R.id.progressBar)
        val calV = findViewById<CalendarView>(R.id.calendarView)

        val i = intent
        var SimulationData =  i.getSerializableExtra("SimulationData") as SimulationDates

        calV.setFirstDayOfWeek(1)
        calV.setFirstDayOfWeek(3)

    }
}