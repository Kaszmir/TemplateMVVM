package pl.kaszmir.templatemvvm.fatures.mock

import org.jetbrains.annotations.TestOnly
import pl.kaszmir.templatemvvm.core.api.remote.model.EntityListBackendResponse
import pl.kaszmir.templatemvvm.core.api.remote.model.EpisodeRemote
import pl.kaszmir.templatemvvm.core.api.remote.model.ResponseInfo
import pl.kaszmir.templatemvvm.fatures.episodes.data.local.model.EpisodeCached

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