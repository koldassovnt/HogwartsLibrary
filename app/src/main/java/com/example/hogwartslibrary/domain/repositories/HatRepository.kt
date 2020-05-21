package com.example.hogwartslibrary.domain.repositories

import com.example.hogwartslibrary.domain.models.FacultyModel

interface HatRepository {
    suspend fun generateFaculty(username: String) : FacultyModel
}