package pl.kaszmir.templatemvvm.fatures.locations.domain

import pl.kaszmir.templatemvvm.core.base.UseCase
import pl.kaszmir.templatemvvm.fatures.locations.LocationRepository
import pl.kaszmir.templatemvvm.fatures.locations.domain.model.Location

class GetMultipleLocationsByIdUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, List<Int>>() {
    override suspend fun action(params: List<Int>): List<Location> =
        locationRepository.getMultipleLocationsById(params)
}