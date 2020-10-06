package pl.kaszmir.templatemvvm.fatures.characters.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import pl.kaszmir.templatemvvm.core.api.remote.RickAndMortyApi
import pl.kaszmir.templatemvvm.core.api.remote.model.EntityListBackendResponse
import pl.kaszmir.templatemvvm.core.network.NetworkStateProvider
import pl.kaszmir.templatemvvm.fatures.characters.data.local.CharacterDao
import pl.kaszmir.templatemvvm.fatures.characters.data.local.model.CharacterCached
import pl.kaszmir.templatemvvm.fatures.mock.mock
import pl.kaszmir.templatemvvm.fatures.mock.mockedGetCharactersResponse

internal class CharacterRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN character request THEN fetch episodes from API`() {

        // GIVEN
        val api = mockk<RickAndMortyApi> {
            coEvery { getCharacters() } returns EntityListBackendResponse.mockedGetCharactersResponse()
        }

        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository = CharacterRepositoryImpl(api, characterDao, networkStateProvider)

        // WHEN
        runBlocking { repository.getCharacters() }

        // THEN
        coVerify { api.getCharacters() }
    }

    @Test
    fun `GIVEN network is connected WHEN episodes request THEN save episodes to local database`() {
        // GIVEN
        val api = mockk<RickAndMortyApi> {
            coEvery { getCharacters() } returns EntityListBackendResponse.mockedGetCharactersResponse()
        }

        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository = CharacterRepositoryImpl(api, characterDao, networkStateProvider)

        // WHEN
        runBlocking { repository.getCharacters() }

        // THEN
        coVerify { characterDao.saveCharacters(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is not connected WHEN episodes request THEN get episodes from local database`() {
        // GIVEN
        val api = mockk<RickAndMortyApi>(relaxed = true)

        val characterDao = mockk<CharacterDao> {
            coEvery { getAllCharacters() } returns listOf(
                CharacterCached.mock(),
                CharacterCached.mock()
            )
        }

        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false // no internet connection
        }

        val repository = CharacterRepositoryImpl(api, characterDao, networkStateProvider)

        // WHEN
        runBlocking { repository.getCharacters() }

        // THEN
        coVerify { characterDao.getAllCharacters() }
    }

}