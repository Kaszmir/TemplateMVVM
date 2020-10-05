package pl.kaszmir.templatemvvm.fatures.characters.presentation.model

import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Character
import pl.kaszmir.templatemvvm.fatures.episodes.presentation.model.OriginDisplayable
import pl.kaszmir.templatemvvm.fatures.locations.presentation.model.LocationDisplayable

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
        location = LocationDisplayable(
            character.location
        ),
        name = character.name,
        origin = OriginDisplayable(
            character.origin
        ),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )

}