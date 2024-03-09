package com.example.aviatickets.model.entity

import com.google.gson.annotations.SerializedName

data class Offer(
    val id: Int,
    val price: Int,
    @SerializedName("is_direct") val isDirect: Boolean,
    val flight: Flight
)
