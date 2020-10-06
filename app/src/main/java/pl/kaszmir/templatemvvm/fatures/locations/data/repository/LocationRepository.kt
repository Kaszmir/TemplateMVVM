package pl.kaszmir.templatemvvm.fatures.locations.data.repository

import pl.kaszmir.templatemvvm.fatures.locations.domain.model.Location


interface LocationRepository {
    suspend fun getLocations(): List<Location>
    suspend fun getLocation(locationId: Int): Location
    suspend fun getMultipleLocationsById(locations: List<Int>): List<Location>
}