package com.example.myapplication.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.Model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}