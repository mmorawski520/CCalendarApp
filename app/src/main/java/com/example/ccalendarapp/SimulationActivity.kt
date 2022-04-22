package com.example.ccalendarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.ProgressBar
import java.util.*

class SimulationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulation)

        val progressb = findViewById<ProgressBar>(R.id.progressBar)
        val calV1 = findViewById<CalendarView>(R.id.calendarView1)
        val btnSwap = findViewById<Button>(R.id.btnSwap)

        var iterator=0;
        val i = intent
        var SimulationData = i.getSerializableExtra("SimulationData") as SimulationDates

        val currentDate = Calendar.getInstance()
        currentDate.set(currentDate.get(Calendar.YEAR), Calendar.DECEMBER, 31)

        calV1.minDate = Date().time
        calV1.setMaxDate(currentDate.timeInMillis)



        val daysBetweenStartAndEnd =
            (SimulationData.endDate.time - SimulationData.beginDate.time).toInt()

        calV1.setDate(SimulationData.beginDate.time)



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
        fun setCurDate(){
            iterator++
            if(iterator>=2){
                calV1.setDate(SimulationData.endDate.time)
                iterator=0
                return
            }
            if(iterator==1){
                calV1.setDate(SimulationData.tempDate.time)

                return
            }
            if(iterator==0) {
                calV1.setDate(SimulationData.beginDate.time)

                return
            }
        }
        btnSwap.setOnClickListener{


            setCurDate()
        }
    }
}