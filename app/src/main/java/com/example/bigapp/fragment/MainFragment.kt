package com.example.bigapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.bigapp.ProductsAdapter
import com.example.bigapp.R
import com.example.bigapp.adapter.CategoriesAdapter
import com.example.bigapp.databaseroom.AppDatabase
import com.example.bigapp.databaseroom.ProductFromDatabase
import com.example.bigapp.model.Product
import com.example.bigapp.repository.ProductsRepository
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_main, container, false)
        val products= arrayListOf<Product>()
        /*for (i in 0..100){
            products.add(Product("Organic Apple #$i",   "https://via.placeholder.com/350/dddddd/000000","22.50"))
        }*/
       /* doAsync {
            val json = URL("https://finepointmobile.com/data/products.json").readText()
            uiThread {
                //d("json","json: $json")
                val products =Gson().fromJson(json,Array<Product>::class.java).toList()
                root.recycle_view.apply { layoutManager = GridLayoutManager(activity,2)
                    adapter= ProductsAdapter(products)
                root.progressBar.visibility=View.GONE
                }
            }
        }*/

        val categorias= listOf("Jeans","Socks","Suits","Skirts","Dresses","Alex")
         root.categoriaReclaView.apply {
             layoutManager= LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false)
             adapter= CategoriesAdapter(categorias)
         }
        return root
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ProductsRepository().getAllProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                recycle_view.apply { layoutManager = GridLayoutManager(activity,2)
                    adapter= ProductsAdapter(it)
                }
                progressBar.visibility=View.GONE
            }, { d("alex","error:( ${it.message}")})
        /*btnSearch.setOnClickListener{
            doAsync {
                val db = Room.databaseBuilder(
                    activity!!.applicationContext,
                    AppDatabase::class.java, "database-name"
                ).build()
                val productsFromDatabase =db.productDao().searchFor("%${searchTerm.text}%")
                val products=productsFromDatabase.map {
                    Product(
                        it.title,
                        "https://finepointmobile.com/data/jeans2.jpg",
                        it.price,
                        true
                    )
                }
                uiThread {
                    //d("json","json: $json")
                    recycle_view.apply { layoutManager = GridLayoutManager(activity,2)
                        adapter= ProductsAdapter(products)
                    }
                    progressBar.visibility=View.GONE
                }
            }

        }*/


    }
}