package com.example.hogwartslibrary.data.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpellRemote(
    @SerialName("_id")
    val id: String = "",
    @SerialName("spell")
    val spell: String = "",
    @SerialName("type")
    val type: String = "",
    @SerialName("effect")
    val effect: String = "",
    @SerialName("__v")
    val version: Int = 0
)