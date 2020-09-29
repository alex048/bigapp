package com.example.bigapp.model

import com.google.gson.annotations.SerializedName

class Product (
    @SerializedName("name")
    val title:String,
    @SerializedName("photo_url")
    val photoUrl:String,
    @SerializedName("price")
    val price:Double?,
    @SerializedName("isOnSale")
    val isOnSales:Boolean
)