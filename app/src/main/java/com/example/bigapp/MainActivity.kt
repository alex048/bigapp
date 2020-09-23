package com.example.bigapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.MenuItem
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bigapp.fragment.DemoFragment
import com.example.bigapp.fragment.MainFragment
import com.example.bigapp.model.Product
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
            }
            it.isChecked=true
            drawerlayout.closeDrawers()
            true}
       supportActionBar?.apply { setDisplayHomeAsUpEnabled(true)
       setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)}

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawerlayout.openDrawer(GravityCompat.START)
        return super.onOptionsItemSelected(item)
    }
}