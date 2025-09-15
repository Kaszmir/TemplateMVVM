package pl.kaszmir.templatemvvm.fatures.data.remote.model

import com.google.gson.annotations.SerializedName
import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Character


data class CharacterRemote(
    @SerializedName("created") val created: String,
    @SerializedName("episode") val episodeList: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("location") val location: LocationRemote,
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: OriginRemote,
    @SerializedName("species") val species: String,
    @SerializedName("status") val status: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {
    fun toCharacter() =
        Character(
            episode = episodeList,
            gender = gender,
            id = id,
            image = image,
            location = location.toLocation(),
            name = name,
            origin = origin.toOrigin(),
            species = species,
            status = status,
            type = type,
            url = url
        )
}

