package com.caiquesenna.produtoapidummyjson.data

import java.io.Serializable

data class Meta(
    val barcode: String,
    val createdAt: String,
    val qrCode: String,
    val updatedAt: String
) : Serializable