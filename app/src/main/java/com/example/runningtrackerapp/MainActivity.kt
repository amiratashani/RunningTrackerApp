package com.example.runningtrackerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.runningtrackerapp.db.Run

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val r = Run(timestamp = 10L)

    }
}