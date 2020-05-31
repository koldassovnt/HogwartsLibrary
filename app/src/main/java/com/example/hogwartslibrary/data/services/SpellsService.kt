package com.example.hogwartslibrary.data.services
import com.example.hogwartslibrary.data.models.SpellRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface SpellsService {

    @GET("spells")
    suspend fun getAllSpells( @Query("key") key: String): List<SpellRemote>
}