package com.caiquesenna.produtoapidummyjson.data

import java.io.Serializable

data class Dimensions(
    val depth: Double,
    val height: Double,
    val width: Double
) : Serializable