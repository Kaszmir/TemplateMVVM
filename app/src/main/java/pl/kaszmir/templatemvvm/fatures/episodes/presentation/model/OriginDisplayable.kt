package pl.kaszmir.templatemvvm.fatures.episodes.presentation.model

import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Origin

data class OriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: Origin) : this(
        name = origin.name,
        url = origin.url
    )
}