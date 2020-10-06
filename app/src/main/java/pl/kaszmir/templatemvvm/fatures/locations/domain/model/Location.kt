package pl.kaszmir.templatemvvm.fatures.locations.domain.model

class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val url: String,
    val residents: List<String>
) {
    companion object
}