package com.caiquesenna.produtoapidummyjson.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.caiquesenna.produtoapidummyjson.data.Product
import com.caiquesenna.produtoapidummyjson.databinding.ActivityDetalhesBinding

class DetalhesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getSerializableExtra("PRODUCT") as? Product
        product?.let {
            binding.txtDetailTitle.text = it.title
            binding.txtDetailPrice.text = "R$ ${it.price}"
            binding.txtDetailDescription.text = it.description
            Glide.with(this).load(it.thumbnail).into(binding.imgDetailProduct)
        }

    }
}