package pl.kaszmir.templatemvvm.fatures.characters.domain.model

import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Origin
import pl.kaszmir.templatemvvm.fatures.locations.domain.model.Location

data class Character(
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)