package pl.kaszmir.templatemvvm.fatures.episodes.domain

import pl.kaszmir.templatemvvm.core.base.UseCase
import pl.kaszmir.templatemvvm.fatures.episodes.data.repository.EpisodeRepository
import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()

}