package com.example.ccalendarapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.ProgressBar

class SimulationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulation)

        val progressb = findViewById<ProgressBar>(R.id.progressBar)
        val calV = findViewById<CalendarView>(R.id.calendarView)

        val i = intent
        var SimulationData = i.getSerializableExtra("SimulationData") as SimulationDates


        val daysBetweenStartAndEnd =
            (SimulationData.endDate.time - SimulationData.beginDate.time).toInt()
        calV.setDate(SimulationData.beginDate.time)

        val thread = Thread {
            try {
                for(i in 1..daysBetweenStartAndEnd){
                    progressb.progress = i
                    Thread.sleep(SimulationData.speed.toLong()*1000)
                }

            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        }
        thread.start()
    }
}