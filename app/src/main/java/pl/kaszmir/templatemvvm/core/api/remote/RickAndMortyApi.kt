package pl.kaszmir.templatemvvm.core.api.remote

import pl.kaszmir.templatemvvm.core.api.remote.model.EntityListBackendResponse
import pl.kaszmir.templatemvvm.core.api.remote.model.EpisodeRemote
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Interface dedicated to communication with backend
 * https://rickandmortyapi.com/documentation/
 */

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EntityListBackendResponse<EpisodeRemote>

    @GET("episode/{episodeId}")
    suspend fun getSingleEpisode(@Path("episodeId") episodeId: Int): EpisodeRemote

    @GET("episode/{episodesId}")
    suspend fun getMultipleEpisodesById(@Path("episodesId") episodesId: List<Int>): EntityListBackendResponse<EpisodeRemote>

}