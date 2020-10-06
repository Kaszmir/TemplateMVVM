package pl.kaszmir.templatemvvm.fatures.characters.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Character
import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Origin
import pl.kaszmir.templatemvvm.fatures.locations.domain.model.Location

@Entity
class CharacterCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val image: String,
    val gender: String,
    val origin: Origin,
    val episodes: List<String>,
    val location: Location,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {

    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        image = character.image,
        gender = character.gender,
        origin = character.origin,
        episodes = character.episode,
        location = character.location,
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )

    fun toCharacter() = Character(
        episode = episodes,
        gender = gender,
        id = id,
        image = image,
        location = location,
        name = name,
        origin = origin,
        species = species,
        status = status,
        type = type,
        url = url
    )

    companion object
}