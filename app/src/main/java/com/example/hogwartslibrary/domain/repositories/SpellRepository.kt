package com.example.hogwartslibrary.domain.repositories

import com.example.hogwartslibrary.domain.models.SpellModel

interface SpellRepository {
    suspend fun getAllSpells(): List<SpellModel>
}