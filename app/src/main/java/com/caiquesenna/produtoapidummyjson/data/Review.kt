package com.caiquesenna.produtoapidummyjson.data

import java.io.Serializable

data class Review(
    val comment: String,
    val date: String,
    val rating: Int,
    val reviewerEmail: String,
    val reviewerName: String
) : Serializable