package pl.kaszmir.templatemvvm.fatures.locations.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.kaszmir.templatemvvm.fatures.locations.domain.model.Location

@Entity
class LocationCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val url: String,
    val residents: List<String>
) {

    constructor(location: Location) : this(
        id = location.id,
        name = location.name,
        type = location.type,
        dimension = location.dimension,
        url = location.url,
        residents = location.residents
    )

    fun toLocation() = Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        url = url,
        residents = residents
    )

    companion object
}


