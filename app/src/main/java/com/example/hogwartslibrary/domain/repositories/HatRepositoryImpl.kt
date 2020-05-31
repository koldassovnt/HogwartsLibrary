package com.example.hogwartslibrary.domain.repositories

import com.example.hogwartslibrary.data.network.RetrofitFactory
import com.example.hogwartslibrary.domain.models.FacultyModel
import kotlinx.coroutines.delay

class HatRepositoryImpl : HatRepository {
    override suspend fun generateFaculty(username: String): FacultyModel {
        return FacultyModel(name = RetrofitFactory.instance.housesServices.getRandomHouse(key = RetrofitFactory.key))

    }
}