package com.example.aviatickets.model.network

import com.example.aviatickets.model.entity.Flight
import retrofit2.Call
import retrofit2.http.GET

interface FlightService {
    @GET("offer_list")
    fun fetchFlightList(): Call<List<Flight>>
}
