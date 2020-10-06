package pl.kaszmir.templatemvvm.core.api.remote.model

import com.google.gson.annotations.SerializedName
import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Origin


data class OriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toOrigin() =
        Origin(name, url)

    companion object
}
