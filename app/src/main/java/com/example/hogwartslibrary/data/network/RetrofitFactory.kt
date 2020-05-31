package com.example.hogwartslibrary.data.network

import com.example.hogwartslibrary.data.services.CharactersService
import com.example.hogwartslibrary.data.services.HousesService
import com.example.hogwartslibrary.data.services.SpellsService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import okhttp3.MediaType.Companion.toMediaType

class RetrofitFactory {

    companion object {
        val instance = RetrofitFactory()
        val key ="\$2a\$10\$hwmIPTHSnZ6auPvyLSI22.TGq33/WzS5Ekoew6Ymb88MfWlfDSSJW"
    }

    private fun okHttpInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(okHttpInterceptor())
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://www.potterapi.com/v1/")
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .client(okHttpClient)
        .build()

    val charactersService: CharactersService = retrofitClient.create(CharactersService::class.java)
    val housesServices: HousesService = retrofitClient.create(HousesService::class.java)
    val spellsService: SpellsService = retrofitClient.create(SpellsService::class.java)

}