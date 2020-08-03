package pl.kaszmir.templatemvvm.fatures.episodes.presentation.model

import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Location

data class LocationDisplayable(
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
}