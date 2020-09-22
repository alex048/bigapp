package com.example.bigapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bigapp.model.Product
import com.squareup.picasso.Picasso

class ProductsAdapter(private val products:ArrayList<Product>):RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
        Picasso.get().load(products[position].photoUrl).into(holder.image)
        holder.name_product.text=products[position].title
        holder.price.text=products[position].price
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row,parent,false)
        val holder=ViewHolder(view)
        view.setOnClickListener{
            val intent = Intent(parent.context,ProductDetails::class.java)
            intent.putExtra("title",products[holder.adapterPosition].title)
            parent.context.startActivity(intent)
        }
        return  holder
    }
    override fun getItemCount() =products.size
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val image:ImageView = itemView.findViewById(R.id.photo)
        val name_product:TextView = itemView.findViewById(R.id.title)
        val price:TextView=itemView.findViewById(R.id.price)
    }
}