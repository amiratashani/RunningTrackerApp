package com.example.runningtrackerapp.db

import androidx.core.content.contentValuesOf
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Run::class], version = 1)
@TypeConverters(BitmapConverter::class)
abstract class RunningDatabase : RoomDatabase() {
    abstract fun getRunDao(): RunDAO
}