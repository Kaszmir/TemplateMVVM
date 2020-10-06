package pl.kaszmir.templatemvvm.core.api.remote.model

import com.google.gson.annotations.SerializedName
import pl.kaszmir.templatemvvm.fatures.locations.domain.model.Location


data class LocationRemote(
    @SerializedName("created") val created: String,
    @SerializedName("dimension") val dimension: String,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("residents") val residents: List<String>,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {
    fun toLocation() =
        Location(
            id = id,
            name = name,
            type = type,
            dimension = dimension,
            url = url,
            residents = residents
        )

    companion object
}
