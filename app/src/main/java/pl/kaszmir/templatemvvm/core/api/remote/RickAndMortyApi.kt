package pl.kaszmir.templatemvvm.core.api.remote

import pl.kaszmir.templatemvvm.core.api.remote.model.CharacterRemote
import pl.kaszmir.templatemvvm.core.api.remote.model.EntityListBackendResponse
import pl.kaszmir.templatemvvm.core.api.remote.model.EpisodeRemote
import pl.kaszmir.templatemvvm.core.api.remote.model.LocationRemote
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Interface dedicated to communication with backend
 * https://rickandmortyapi.com/documentation/
 */

interface RickAndMortyApi {


    /**
     * Episode
     */

    @GET("episode")
    suspend fun getEpisodes(): EntityListBackendResponse<EpisodeRemote>

    @GET("episode/{episodeId}")
    suspend fun getSingleEpisode(@Path("episodeId") episodeId: Int): EpisodeRemote

    @GET("episode/{episodesId}")
    suspend fun getMultipleEpisodesById(@Path("episodesId") episodesId: List<Int>): EntityListBackendResponse<EpisodeRemote>


    /**
     * Character
     */

    @GET("character")
    suspend fun getCharacters(): EntityListBackendResponse<CharacterRemote>

    @GET("character/{characterId}")
    suspend fun getSingleCharacter(@Path("characterId") characterId: Int): CharacterRemote

    @GET("character/{charactersId}")
    suspend fun getMultipleCharactersById(@Path("charactersId") charactersId: List<Int>): EntityListBackendResponse<CharacterRemote>


    /**
     * Location
     */

    @GET("location")
    suspend fun getAllLocations(): EntityListBackendResponse<LocationRemote>

    @GET("location/{locationIds}")
    suspend fun getMultipleLocations(@Path("locationIds") locationIds: List<Int>): EntityListBackendResponse<LocationRemote>

    @GET("location/{locationId}")
    suspend fun getLocationById(@Path("locationId") locationId: Int): LocationRemote
}