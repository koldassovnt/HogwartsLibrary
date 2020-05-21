package com.example.hogwartslibrary.domain.repositories

import com.example.hogwartslibrary.domain.models.StudentModel

interface StudentsRepository {
    suspend fun fetchStudents(): List<StudentModel>
}