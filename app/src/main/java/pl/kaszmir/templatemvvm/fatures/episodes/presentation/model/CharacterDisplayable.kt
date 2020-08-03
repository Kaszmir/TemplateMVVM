package pl.kaszmir.templatemvvm.fatures.episodes.presentation.model

import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Character

data class CharacterDisplayable(
    val episodeList: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDisplayable,
    val name: String,
    val origin: OriginDisplayable,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {

    constructor(character: Character) : this(
        episodeList = character.episode,
        gender = character.gender,
        id = character.id,
        image = character.image,
        location = LocationDisplayable(character.location),
        name = character.name,
        origin = OriginDisplayable(character.origin),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )

}