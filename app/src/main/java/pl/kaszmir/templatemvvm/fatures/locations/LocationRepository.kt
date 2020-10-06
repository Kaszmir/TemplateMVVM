package pl.kaszmir.templatemvvm.fatures.locations

import pl.kaszmir.templatemvvm.fatures.locations.domain.model.Location


interface LocationRepository {
    fun getLocations(): List<Location>
    fun getLocation(locationId: Int): Location
    fun getMultipleLocationsById(locations: List<Int>): List<Location>
}