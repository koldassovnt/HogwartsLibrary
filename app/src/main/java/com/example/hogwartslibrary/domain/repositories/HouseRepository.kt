package com.example.hogwartslibrary.domain.repositories

import com.example.hogwartslibrary.domain.models.HouseModel
import com.example.hogwartslibrary.ui.scenes.house.Houses

interface HouseRepository {

   suspend fun getHouseDetails(house: Houses): HouseModel?

}