package com.nahuelbutaeste.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Fauna(
    val nombre: String,
    val nombreCientifico: String,
    val categoria: String,
    val reino: String,
    val familia: String,
    val especie: String,
    val clase: String,
    val imagen: String,
    val cantidadEspecie: Int,
    val sonido: String,
    val descripcion: String
)
