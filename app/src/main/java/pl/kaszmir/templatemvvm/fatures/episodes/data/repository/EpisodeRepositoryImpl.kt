package pl.kaszmir.templatemvvm.fatures.episodes.data.repository

import pl.kaszmir.templatemvvm.core.api.remote.RickAndMortyApi
import pl.kaszmir.templatemvvm.core.network.NetworkStateProvider
import pl.kaszmir.templatemvvm.fatures.episodes.EpisodeRepository
import pl.kaszmir.templatemvvm.fatures.episodes.data.local.EpisodeDao
import pl.kaszmir.templatemvvm.fatures.episodes.data.local.model.EpisodeCached
import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val api: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider
) : EpisodeRepository {

    /**
     * [EpisodeRepository]
     */

    override suspend fun getEpisodes(): List<Episode> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getEpisodesFromRemote()
                .also { saveEpisodesToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    override suspend fun getSingleEpisode(episodeId: Int): Episode {

        return if (networkStateProvider.isNetworkAvailable()) {
            api.getSingleEpisode(episodeId).toEpisode()
        } else {
            episodeDao.getSingleEpisode(episodeId).toEpisode()
        }
    }

    override suspend fun getMultipleEpisodesById(episodesId: List<Int>): List<Episode> {
        return api.getMultipleEpisodesById(episodesId).result.map { it.toEpisode() }
    }


    /**
     * Private functions
     */

    private suspend fun getEpisodesFromRemote(): List<Episode> {
        return api.getEpisodes()
            .result
            .map { it.toEpisode() }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
        return episodeDao.getEpisodes().map { it.toEpisode() }
    }

    private suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) } // *it because we want to use typedArray
    }
}