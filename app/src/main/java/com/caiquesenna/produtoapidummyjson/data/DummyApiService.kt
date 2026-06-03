package com.caiquesenna.produtoapidummyjson.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyApiService {
    @GET("products")
    suspend fun getProducts(): Response<ProductResponse>
    @GET ("products/search")
    suspend fun searchProducts(@Query("q") query: String): Response<ProductResponse>
}