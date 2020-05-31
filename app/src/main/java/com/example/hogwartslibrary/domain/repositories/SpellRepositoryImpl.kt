package com.example.hogwartslibrary.domain.repositories

import com.example.hogwartslibrary.data.network.RetrofitFactory
import com.example.hogwartslibrary.domain.models.SpellModel
import com.example.hogwartslibrary.domain.models.mapToModel

class SpellRepositoryImpl: SpellRepository {
    override suspend fun getAllSpells(): List<SpellModel> {
        return RetrofitFactory.instance.spellsService.getAllSpells(key = RetrofitFactory.key)
            .map { it.mapToModel() }
    }
}