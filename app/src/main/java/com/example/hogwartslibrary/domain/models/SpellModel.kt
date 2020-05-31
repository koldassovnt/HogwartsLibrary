package com.example.hogwartslibrary.domain.models

import com.example.hogwartslibrary.data.models.SpellRemote

data class SpellModel (val id: String, val name: String, val type: String)

fun SpellRemote.mapToModel(): SpellModel {
    return SpellModel(id = this.id, name = this.spell, type = this.type)
}
