package com.example.hogwartslibrary.domain.models

import com.example.hogwartslibrary.data.models.HouseRemote

data class HouseModel (val name: String, val leader: String, val founder: String, val ghost: String)

fun HouseRemote.mapToModel(): HouseModel {
    return HouseModel(name = this.name, leader = this.headOfHouse, founder = this.founder, ghost = this.houseGhost)
}