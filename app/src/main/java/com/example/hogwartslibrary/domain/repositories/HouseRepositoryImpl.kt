package com.example.hogwartslibrary.domain.repositories

import com.example.hogwartslibrary.data.network.RetrofitFactory
import com.example.hogwartslibrary.data.services.HousesService
import com.example.hogwartslibrary.domain.models.HouseModel
import com.example.hogwartslibrary.domain.models.mapToModel
import com.example.hogwartslibrary.ui.scenes.house.Houses
import java.lang.Exception

class HouseRepositoryImpl: HouseRepository {
    override suspend fun getHouseDetails(house: Houses): HouseModel? {
        val houseId = when (house) {
            Houses.Gryffindor -> HousesService.griffindorId
            Houses.Slytherin -> HousesService.slytherinId
            Houses.Ravenclaw -> HousesService.ravenclawId
            Houses.Hufflepuff -> HousesService.hufflepuffId
        }

        return try {
            RetrofitFactory.instance.housesServices.getHouseDetails(
                key = RetrofitFactory.key,
                houseId = houseId
            )
                .map { it.mapToModel() }[0]
        } catch (e: Exception) {
            return null
        }
    }

}