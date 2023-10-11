package com.nahuelbutaeste.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Flora(
    val id: Int,
    val nombre: String,
    val nombreCientifico: String,
    val imagen: String,
    val familia: String,
    val reino: String,
    val cantidadEspecie: Int,
    val uso: String,
    val categoria: String,
    val clasificacion: String,
    val descripcion: String,
    val origen: String
)