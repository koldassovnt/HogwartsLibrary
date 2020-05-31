package com.example.hogwartslibrary.domain.models

import com.example.hogwartslibrary.data.models.CharacterRemote

data class StudentModel(val id: String, val name: String, val facultyName: String, val bloodStatus: String, val species: String)

fun CharacterRemote.mapToModel() : StudentModel {
    return StudentModel(id = this.id, name = this.name, facultyName = this.house, bloodStatus = this.bloodStatus, species = this.species)
}