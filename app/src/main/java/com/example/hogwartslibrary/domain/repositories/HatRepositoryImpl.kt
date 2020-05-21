package com.example.hogwartslibrary.domain.repositories

import com.example.hogwartslibrary.domain.models.FacultyModel
import kotlinx.coroutines.delay

class HatRepositoryImpl : HatRepository {
    override suspend fun generateFaculty(username: String): FacultyModel {
        delay(2000)

        return if (username == "Harry Potter")
            FacultyModel(name = "Griffindor")
        else
            FacultyModel(name = "Slytherin")
    }
}