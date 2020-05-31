package com.example.hogwartslibrary.ui.scenes.students.adapters

import com.example.hogwartslibrary.domain.models.StudentModel

data class StudentCellModel(val id: String, val name: String, val facultyName: String, val species: String)

fun StudentModel.mapToUI() : StudentCellModel {
    return StudentCellModel(id = this.id, name = this.name, facultyName = this.facultyName, species = this.species)
}