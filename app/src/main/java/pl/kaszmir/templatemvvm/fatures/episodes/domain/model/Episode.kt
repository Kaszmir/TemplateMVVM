package pl.kaszmir.templatemvvm.fatures.episodes.domain.model

data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val characters: List<String>,
    val episodeCode: String,
    val url: String
) {
    companion object
}