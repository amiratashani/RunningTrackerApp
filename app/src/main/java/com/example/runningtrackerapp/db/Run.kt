package com.example.runningtrackerapp.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Running_table")
data class Run(
    var img: Bitmap? = null,
    var timestamp: Long ,
    var avgSpeedInKMH: Float = 0f,
    var distanceInMeters: Int = 0,
    var timeInMillis: Long = 0L,
    var caloriesBurned: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}