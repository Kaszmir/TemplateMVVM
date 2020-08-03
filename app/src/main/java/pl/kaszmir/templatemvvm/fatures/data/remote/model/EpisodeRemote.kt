package pl.kaszmir.templatemvvm.fatures.data.remote.model

import com.google.gson.annotations.SerializedName
import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Episode

data class EpisodeRemote(
    @SerializedName("air_date") val airDate: String,
    @SerializedName("characters") val characters: List<String>,
    @SerializedName("created") val created: String,
    @SerializedName("episode") val episodeCode: String,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        characters = characters,
        episodeCode = episodeCode,
        url = url
    )
}