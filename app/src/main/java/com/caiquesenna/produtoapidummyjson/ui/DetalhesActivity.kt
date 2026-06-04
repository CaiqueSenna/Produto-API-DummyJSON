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

       //Configuração da Toolbar
        binding.toolbarDetalhes.setNavigationOnClickListener {
            finish()
        }
        // CORREÇÃO DO EDGE-TO-EDGE: Empurra a Toolbar para baixo do relógio
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(binding.toolbarDetalhes) { view, insets ->
            val statusBars = insets.getInsets(androidx.core.view.WindowInsetsCompat.Type.statusBars())

            // Aplica a altura da barra de status como preenchimento superior da Toolbar
            view.setPadding(view.paddingLeft, statusBars.top, view.paddingRight, view.paddingBottom)

            insets
        }

        val product = intent.getSerializableExtra("PRODUCT") as? Product
        product?.let {
            binding.txtDetailTitle.text = it.title
            binding.txtDetailPrice.text = "R$ ${it.price}"
            binding.txtDetailDescription.text = it.description
            binding.txtDetailDimensions.text = it.dimensions.toString()
            binding.txtDetailStock.text = "Estoque: ${it.stock.toString()}"
            binding.txtDetailMinimumOrderQuant.text = "Minimo: ${it.minimumOrderQuantity.toString()}"
            binding.txtDetailSku.text = "SKU: ${it.sku}"
            Glide.with(this).load(it.thumbnail).into(binding.imgDetailProduct)
        }

    }

}