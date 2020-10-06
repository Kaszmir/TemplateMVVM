package pl.kaszmir.templatemvvm.fatures.episodes.data.local.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Episode

@Entity
class EpisodeCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val airDate: String,
    val episodeCode: String,
    val characters: List<String>,
    val url: String
) {

    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        episodeCode = episode.episodeCode,
        characters = episode.characters,
        url = episode.url
    )

    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        episodeCode = episodeCode,
        characters = characters,
        url = url
    )

    companion object
}