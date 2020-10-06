package pl.kaszmir.templatemvvm.fatures.mock

import org.jetbrains.annotations.TestOnly
import pl.kaszmir.templatemvvm.core.api.remote.model.*
import pl.kaszmir.templatemvvm.fatures.characters.data.local.model.CharacterCached
import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Origin
import pl.kaszmir.templatemvvm.fatures.episodes.data.local.model.EpisodeCached
import pl.kaszmir.templatemvvm.fatures.locations.data.local.model.LocationCached
import pl.kaszmir.templatemvvm.fatures.locations.domain.model.Location

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page test url",
    prev = "prev page test url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "test name",
    airDate = "test air date",
    episodeCode = "test episode code",
    characters = emptyList(),
    created = "test created",
    url = "test url"
)

@TestOnly
fun EntityListBackendResponse.Companion.mockedGetEpisodesResponse() = EntityListBackendResponse(
    info = ResponseInfo.mock(),
    result = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "test name",
    airDate = "test air date",
    episodeCode = "test episode code",
    characters = emptyList(),
    url = "test url"
)

@TestOnly
fun EntityListBackendResponse.Companion.mockedGetCharactersResponse() = EntityListBackendResponse(
    info = ResponseInfo.mock(),
    result = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    created = "test created",
    id = 1,
    name = "test char name",
    image = "test char image",
    gender = "test gender",
    origin = OriginRemote.mock(),
    episodeList = emptyList(),
    location = LocationRemote.mock(),
    species = "test species",
    status = "test status",
    type = "test type",
    url = "test char url"
)

@TestOnly
fun OriginRemote.Companion.mock() = OriginRemote(
    name = "test origin name",
    url = "test origin url"
)

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    created = "test location created",
    id = 1,
    name = "test location name",
    type = "test location type",
    dimension = "test location dimension",
    url = "test location url",
    residents = emptyList()
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    name = "test char name",
    image = "test char image",
    gender = "test gender",
    origin = Origin.mock(),
    episodes = emptyList(),
    location = Location.mock(),
    species = "test species",
    status = "test status",
    type = "test type",
    url = "test char url"
)


@TestOnly
fun Location.Companion.mock() = Location(
    id = 1,
    name = "test location name",
    type = "test location type",
    dimension = "test location dimension",
    url = "test location url",
    residents = emptyList()
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    name = "test location name",
    type = "test location type",
    dimension = "test dimension",
    url = "test location url",
    residents = emptyList()
)

@TestOnly
fun Origin.Companion.mock() =
    Origin(
        name = "test origin name",
        url = "test origin url"
    )

@TestOnly
fun EntityListBackendResponse.Companion.mockedLocationListResponse() = EntityListBackendResponse(
    info = ResponseInfo.mock(),
    result = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)