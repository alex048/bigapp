package com.example.bigapp

import android.content.DialogInterface
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        val title=intent.getStringExtra("title")
        val imagen=intent.getStringExtra("imagen")
        product_name.text=title
        Picasso.get().load(imagen).into(photo)

        availability.setOnClickListener{
            AlertDialog.Builder(this)
                .setMessage("Hey, $title is in stock!")
                .setPositiveButton("ok"
                ) { p0, p1 -> TODO("Not yet implemented") }
                .create()
                .show()
        }
    }
}