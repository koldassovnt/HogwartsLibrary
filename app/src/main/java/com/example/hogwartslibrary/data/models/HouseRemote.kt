package com.example.hogwartslibrary.data.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HouseRemote (
    @SerialName("_id")
    val id: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("mascot")
    val mascot: String = "",
    @SerialName("headOfHouse")
    val headOfHouse: String = "",
    @SerialName("houseGhost")
    val houseGhost: String = "",
    @SerialName("founder")
    val founder: String = "",
    @SerialName("__v")
    val v: Int,
    @SerialName("school")
    val school: String = "",
    @SerialName("members")
    val members: List<HouseMembers> = listOf(),
    @SerialName("values")
    val values: List<String> = listOf(),
    @SerialName("colors")
    val colors: List<String> = listOf()
)

@Serializable
data class HouseMembers(
    val _id: String,
    val name: String
)