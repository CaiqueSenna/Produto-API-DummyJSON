package com.caiquesenna.produtoapidummyjson.data

data class ProductResponse(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)