package com.example.hogwartslibrary.data.services

import com.example.hogwartslibrary.data.models.HouseRemote
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HousesService {

    companion object {
        val griffindorId = "5a05e2b252f721a3cf2ea33f"
        val ravenclawId = "5a05da69d45bd0a11bd5e06f"
        val slytherinId = "5a05dc8cd45bd0a11bd5e071"
        val hufflepuffId = "5a05dc58d45bd0a11bd5e070"
    }

    @GET("sortingHat")
    suspend fun getRandomHouse(@Query("key") key: String): String

    @GET("houses/{houseId}")
    suspend fun getHouseDetails(@Path("houseId") houseId: String, @Query("key") key: String): List<HouseRemote>
}