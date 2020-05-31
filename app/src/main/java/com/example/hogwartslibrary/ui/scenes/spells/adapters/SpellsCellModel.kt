package com.example.hogwartslibrary.ui.scenes.spells.adapters

import com.example.hogwartslibrary.domain.models.SpellModel

data class SpellsCellModel(val name: String, val type: String)

fun SpellModel.mapToUI(): SpellsCellModel {
    return SpellsCellModel(name = this.name, type = this.type)
}