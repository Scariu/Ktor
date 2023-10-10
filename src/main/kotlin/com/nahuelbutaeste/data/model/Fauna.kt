package com.nahuelbutaeste.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Fauna(
    val nombre: String,
    val descripcion: String,
    val imagen: String
)
