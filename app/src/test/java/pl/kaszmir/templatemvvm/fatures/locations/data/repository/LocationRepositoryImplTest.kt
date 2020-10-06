package pl.kaszmir.templatemvvm.fatures.locations.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import pl.kaszmir.templatemvvm.core.api.remote.RickAndMortyApi
import pl.kaszmir.templatemvvm.core.api.remote.model.EntityListBackendResponse
import pl.kaszmir.templatemvvm.core.network.NetworkStateProvider
import pl.kaszmir.templatemvvm.fatures.locations.data.local.LocationDao
import pl.kaszmir.templatemvvm.fatures.locations.data.local.model.LocationCached
import pl.kaszmir.templatemvvm.fatures.mock.mock
import pl.kaszmir.templatemvvm.fatures.mock.mockedLocationListResponse

internal class LocationRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN episodes request THEN fetch episodes from API`() {

        // GIVEN
        val api = mockk<RickAndMortyApi> {
            coEvery { getAllLocations() } returns EntityListBackendResponse.mockedLocationListResponse()
        }

        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository = LocationRepositoryImpl(api, locationDao, networkStateProvider)

        // WHEN
        runBlocking { repository.getLocations() }

        // THEN
        coVerify { api.getAllLocations() }
    }

    @Test
    fun `GIVEN network is connected WHEN episodes request THEN save episodes to local database`() {
        // GIVEN
        val api = mockk<RickAndMortyApi> {
            coEvery { getAllLocations() } returns EntityListBackendResponse.mockedLocationListResponse()
        }

        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository = LocationRepositoryImpl(api, locationDao, networkStateProvider)

        // WHEN
        runBlocking { repository.getLocations() }

        // THEN
        coVerify { locationDao.saveLocations(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is not connected WHEN episodes request THEN get episodes from local database`() {
        // GIVEN
        val api = mockk<RickAndMortyApi>(relaxed = true)

        val locationDao = mockk<LocationDao> {
            coEvery { getAllLocations() } returns listOf(
                LocationCached.mock(),
                LocationCached.mock()
            )
        }

        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false // no internet connection
        }

        val repository = LocationRepositoryImpl(api, locationDao, networkStateProvider)

        // WHEN
        runBlocking { repository.getLocations() }

        // THEN
        coVerify { locationDao.getAllLocations() }
    }

}