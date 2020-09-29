package com.example.bigapp.databaseroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data  class ProductFromDatabase (
    @PrimaryKey(autoGenerate = true)
    val uid: Int?,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "price")
    val price: Double?
)