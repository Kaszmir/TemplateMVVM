package pl.kaszmir.templatemvvm.fatures.locations.domain

import pl.kaszmir.templatemvvm.core.base.UseCase
import pl.kaszmir.templatemvvm.fatures.locations.data.repository.LocationRepository
import pl.kaszmir.templatemvvm.fatures.locations.domain.model.Location

class GetLocationByIdUseCase(private val locationRepository: LocationRepository) :
    UseCase<Location, Int>() {
    override suspend fun action(params: Int): Location = locationRepository.getLocation(params)
}