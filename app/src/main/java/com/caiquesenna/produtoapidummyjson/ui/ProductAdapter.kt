package com.caiquesenna.produtoapidummyjson.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.caiquesenna.produtoapidummyjson.data.Product
import com.caiquesenna.produtoapidummyjson.databinding.ItemProductBinding

class ProductAdapter (
    private var productList: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder{
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        with(holder.binding){
            txtTitle.text = product.title
            txtPrice.text = "R$ ${product.price}"
            Glide.with(root.context).load(product.thumbnail).into(imgProduct)
            root.setOnClickListener { onItemClick(product) }
        }
    }
    override fun getItemCount(): Int = productList.size

    fun updateList(newList: List<Product>){
        productList = newList
        notifyDataSetChanged()
    }

}