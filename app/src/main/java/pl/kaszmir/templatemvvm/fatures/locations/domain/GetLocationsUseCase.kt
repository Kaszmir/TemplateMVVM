package pl.kaszmir.templatemvvm.fatures.locations.domain

import pl.kaszmir.templatemvvm.core.base.UseCase
import pl.kaszmir.templatemvvm.fatures.locations.data.repository.LocationRepository
import pl.kaszmir.templatemvvm.fatures.locations.domain.model.Location

class GetLocationsUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {
    override suspend fun action(params: Unit): List<Location> = locationRepository.getLocations()
}