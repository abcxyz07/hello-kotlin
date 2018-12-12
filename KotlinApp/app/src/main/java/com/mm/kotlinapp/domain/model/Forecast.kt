package com.mm.kotlinapp.domain.model


data class Forecast(
    val date: String,
    val desc: String,
    val max: Int,
    val min: Int
)
