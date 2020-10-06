package pl.kaszmir.templatemvvm.fatures.episodes.presentation.model

import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Episode

data class EpisodeDisplayable(
    val id: Int,
    val name: String,
    val airDate: String,
    val characters: List<String>,
    val episodeCode: String,
    val url: String
) {

    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        characters = episode.characters,
        episodeCode = episode.episodeCode,
        url = episode.url
    )

}