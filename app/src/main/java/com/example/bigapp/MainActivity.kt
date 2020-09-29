package com.example.bigapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.Menu
import android.view.MenuItem
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.bigapp.cart.CartActivity
import com.example.bigapp.databaseroom.AppDatabase
import com.example.bigapp.databaseroom.ProductFromDatabase
import com.example.bigapp.fragment.AdminFragment
import com.example.bigapp.fragment.DemoFragment
import com.example.bigapp.fragment.MainFragment
import com.example.bigapp.model.Product
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*doAsync {
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
            ).build()

            db.productDao().insertAll(ProductFromDatabase(null,"Socks - one dozen",1.99))
            val products =db.productDao().getAll()
            uiThread {
                d("products","producta size ? ${products.size}")
            }
        }*/


        supportFragmentManager.beginTransaction().replace(R.id.framelayout,MainFragment()).commit()
        navigationView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.item1 ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout,MainFragment())
                        .commit()
                 }
                R.id.item2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout,DemoFragment())
                        .commit()
                }
                R.id.item3 -> d("item 3","exitos")
                R.id.item4 -> d("item 4","exitos")
                R.id.item5 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout,AdminFragment())
                        .commit()
                }
            }
            it.isChecked=true
            drawerlayout.closeDrawers()
            true}
       supportActionBar?.apply { setDisplayHomeAsUpEnabled(true)
       setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)}

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId == R.id.actionCar){
            startActivity(Intent(this,CartActivity::class.java))
            return  true
        }
        drawerlayout.openDrawer(GravityCompat.START)
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_tolbard,menu)
        return true
    }
}