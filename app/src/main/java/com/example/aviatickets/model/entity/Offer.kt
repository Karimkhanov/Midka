package com.example.aviatickets.model.entity

data class Offer(
    val id: String,
    val price: Int,
    val flight: Flight
)