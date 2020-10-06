package pl.kaszmir.templatemvvm.fatures.locations.data.repository

import pl.kaszmir.templatemvvm.core.api.remote.RickAndMortyApi
import pl.kaszmir.templatemvvm.core.network.NetworkStateProvider
import pl.kaszmir.templatemvvm.fatures.locations.data.local.LocationDao
import pl.kaszmir.templatemvvm.fatures.locations.data.local.model.LocationCached
import pl.kaszmir.templatemvvm.fatures.locations.domain.model.Location

class LocationRepositoryImpl(
    private val api: RickAndMortyApi,
    private val dao: LocationDao,
    private val networkStateProvider: NetworkStateProvider
) : LocationRepository {

    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            // fetch data
            getAllLocationsFromRemote()
                .also { saveLocationsLocal(it) }
        } else {
            // get data from local db
            dao.getAllLocations()
                .map { it.toLocation() }
        }
    }

    override suspend fun getLocation(locationId: Int): Location {
        return if (networkStateProvider.isNetworkAvailable()) {
            api.getLocationById(locationId).toLocation()
        } else {
            dao.getSingleLocation(locationId).toLocation()
        }
    }

    override suspend fun getMultipleLocationsById(locations: List<Int>): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            api.getMultipleLocations(locations).result.map { it.toLocation() }
        } else {
            val cachedList = mutableListOf<Location>() // create empty list

            locations.forEach { // iterate through locations id list
                cachedList.add(
                    // get location by id from db and add it to the list
                    dao.getSingleLocation(it).toLocation()
                )
            }

            cachedList // return filled list
        }
    }


    /**
     * Private functions
     */

    private suspend fun getAllLocationsFromRemote(): List<Location> {
        return api.getAllLocations()
            .result
            .map { it.toLocation() }
    }

    private suspend fun saveLocationsLocal(locations: List<Location>) {
        locations.map { LocationCached(it) }
            .toTypedArray()
            .let { dao.saveLocations(*it) }

    }


}