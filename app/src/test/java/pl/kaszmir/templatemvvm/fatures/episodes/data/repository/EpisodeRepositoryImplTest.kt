package pl.kaszmir.templatemvvm.fatures.episodes.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import pl.kaszmir.templatemvvm.core.api.remote.RickAndMortyApi
import pl.kaszmir.templatemvvm.core.api.remote.model.EntityListBackendResponse
import pl.kaszmir.templatemvvm.core.network.NetworkStateProvider
import pl.kaszmir.templatemvvm.fatures.episodes.data.local.EpisodeDao
import pl.kaszmir.templatemvvm.fatures.episodes.data.local.model.EpisodeCached
import pl.kaszmir.templatemvvm.fatures.mock.mock
import pl.kaszmir.templatemvvm.fatures.mock.mockedGetEpisodesResponse

internal class EpisodeRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN episodes request THEN fetch episodes from API`() {

        // GIVEN
        val api = mockk<RickAndMortyApi> {
            coEvery { getEpisodes() } returns EntityListBackendResponse.mockedGetEpisodesResponse()
        }

        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository = EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        // WHEN
        runBlocking { repository.getEpisodes() }

        // THEN
        coVerify { api.getEpisodes() }
    }

    @Test
    fun `GIVEN network is connected WHEN episodes request THEN save episodes to local database`() {
        // GIVEN
        val api = mockk<RickAndMortyApi> {
            coEvery { getEpisodes() } returns EntityListBackendResponse.mockedGetEpisodesResponse()
        }

        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository = EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        // WHEN
        runBlocking { repository.getEpisodes() }

        // THEN
        coVerify { episodeDao.saveEpisodes(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is not connected WHEN episodes request THEN get episodes from local database`() {
        // GIVEN
        val api = mockk<RickAndMortyApi>(relaxed = true)

        val episodeDao = mockk<EpisodeDao> {
            coEvery { getEpisodes() } returns listOf(EpisodeCached.mock(), EpisodeCached.mock())
        }

        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false // no internet connection
        }

        val repository = EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        // WHEN
        runBlocking { repository.getEpisodes() }

        // THEN
        coVerify { episodeDao.getEpisodes() }
    }

}