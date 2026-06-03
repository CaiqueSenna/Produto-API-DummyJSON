package com.caiquesenna.produtoapidummyjson.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.caiquesenna.produtoapidummyjson.data.RetrofitClient
import com.caiquesenna.produtoapidummyjson.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        fetchProducts()
        setupSearchView()
    }

    private fun setupRecyclerView() {
        productAdapter = ProductAdapter(emptyList()) { product ->
            val intent = Intent(this, DetalhesActivity::class.java).apply {
                putExtra("PRODUCT", product)
        }
            startActivity(intent)
    }
        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = productAdapter
        }
    }

    private fun fetchProducts(){
        lifecycleScope.launch(Dispatchers.IO){
            try {
                val response = RetrofitClient.apiService.getProducts()
                if (response.isSuccessful){
                    val products = response.body()?.products?: emptyList()
                    withContext(Dispatchers.Main){productAdapter.updateList(products)}
                }
            } catch (e: Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@MainActivity, "Errp de Conexão", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupSearchView(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { searchProducts(it) }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { searchProducts(it) }
                return true
            }
        })
    }
    private fun searchProducts(query: String){
        lifecycleScope.launch (Dispatchers.IO) {
            try {
                val response = RetrofitClient.apiService.searchProducts(query)
                if (response.isSuccessful) {
                    val products = response.body()?.products ?: emptyList()
                    withContext(Dispatchers.Main) { productAdapter.updateList(products) }
                }
            } catch (e: Exception) {
            }
        }
    }
}