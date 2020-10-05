package pl.kaszmir.templatemvvm.fatures.episodes.domain

import pl.kaszmir.templatemvvm.core.base.UseCase
import pl.kaszmir.templatemvvm.fatures.episodes.EpisodeRepository
import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Episode

class GetSingleEpisodeUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<Episode, Int>() {

    override suspend fun action(params: Int): Episode = episodeRepository.getSingleEpisode(params)
}