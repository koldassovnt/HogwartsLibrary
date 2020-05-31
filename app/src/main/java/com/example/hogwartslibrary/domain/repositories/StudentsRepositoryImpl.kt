package com.example.hogwartslibrary.domain.repositories

import com.example.hogwartslibrary.data.network.RetrofitFactory
import com.example.hogwartslibrary.domain.models.StudentModel
import com.example.hogwartslibrary.domain.models.mapToModel
import kotlinx.coroutines.delay
import java.lang.Exception

class StudentsRepositoryImpl: StudentsRepository {
    override suspend fun fetchStudents(): List<StudentModel>? {
        return try {
            RetrofitFactory.instance.charactersService.getAllCharacters(key = RetrofitFactory.key)
                .filter { it.role == "student" }
                .filter { it.house.isNotEmpty() }
                .map { it.mapToModel() }
        } catch (e: Exception) {
            null
        }
    }
}