package com.example.bigapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bigapp.model.Product
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationView.setNavigationItemSelectedListener{
            it.isChecked=true
            true}
        val products= arrayListOf<Product>()
        for (i in 0..100){
            products.add(Product("Organic Apple #$i",   "https://via.placeholder.com/350/dddddd/000000","22.50"))
        }
        recycle_view.apply { layoutManager = GridLayoutManager(this@MainActivity,2)
            adapter= ProductsAdapter(products)
        }
    }
}