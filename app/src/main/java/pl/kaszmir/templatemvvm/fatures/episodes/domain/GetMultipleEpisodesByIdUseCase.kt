package pl.kaszmir.templatemvvm.fatures.episodes.domain

import pl.kaszmir.templatemvvm.core.base.UseCase
import pl.kaszmir.templatemvvm.fatures.episodes.data.repository.EpisodeRepository
import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Episode

class GetMultipleEpisodesByIdUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, List<Int>>() {
    override suspend fun action(params: List<Int>): List<Episode> =
        episodeRepository.getMultipleEpisodesById(params)
}