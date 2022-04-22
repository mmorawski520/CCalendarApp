package com.example.ccalendarapp

import java.io.Serializable
import java.util.*

open class SimulationDates(beginDate: Date, tempDate:Date, endDate:Date, speed:Double) : Serializable  {
    var beginDate: Date= Date();
    var tempDate: Date= Date();
    var endDate: Date=Date();
    var speed: Double = 1.0;

    init {
        this.beginDate=beginDate;
        this.tempDate=tempDate;
        this.endDate=endDate;
        this.speed= speed
    }
}