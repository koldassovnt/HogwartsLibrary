package com.example.hogwartslibrary.domain.repositories

import com.example.hogwartslibrary.domain.models.StudentModel
import kotlinx.coroutines.delay

class StudentsRepositoryImpl: StudentsRepository {
    override suspend fun fetchStudents(): List<StudentModel> {
        delay(2000)

        return listOf(
            StudentModel(1, "Harry", "Potter", "Griffindor"),
            StudentModel(2, "Ronald", "Whisley", "Griffindor"),
            StudentModel(3, "Drago", "Malphoy", "Slitherin"),
            StudentModel(4, "Sedrik", "Diggori", "Ravenclaw")
        )
    }
}