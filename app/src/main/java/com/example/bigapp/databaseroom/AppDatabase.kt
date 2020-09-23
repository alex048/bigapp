package com.example.bigapp.databaseroom

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ProductFromDatabase::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): ProductDao
}