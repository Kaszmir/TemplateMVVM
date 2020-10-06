package pl.kaszmir.templatemvvm.fatures.episodes

import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
    suspend fun getSingleEpisode(episodeId: Int): Episode
    suspend fun getMultipleEpisodesById(episodesId: List<Int>): List<Episode>
}