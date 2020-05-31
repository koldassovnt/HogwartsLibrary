package com.example.hogwartslibrary.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterRemote (
    @SerialName("_id")
    val id: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("role")
    val role: String = "",
    @SerialName("house")
    val house: String = "",
    @SerialName("school")
    val school: String = "",
    @SerialName("__v")
    val v: Int,
    @SerialName("ministryOfMagic")
    val ministryOfMagic: Boolean,
    @SerialName("orderOfThePhoenix")
    val orderOfThePhoenix: Boolean,
    @SerialName("dumbledoresArmy")
    val dumbledoresArmy: Boolean,
    @SerialName("deathEater")
    val deathEater: Boolean,
    @SerialName("bloodStatus")
    val bloodStatus: String = "",
    @SerialName("species")
    val species: String = "",
    @SerialName("boggart")
    val boggart: String = "",
    @SerialName("alias")
    val alias: String = "",
    @SerialName("animagus")
    val animagus: String = "",
    @SerialName("wand")
    val wand: String = "",
    @SerialName("patronus")
    val patronus: String = ""
    )