package pl.kaszmir.templatemvvm.fatures.episodes.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test
import pl.kaszmir.templatemvvm.fatures.episodes.EpisodeRepository


internal class GetEpisodesUseCaseTest {

    @Test
    fun `when use case will be invoked than execute getEpisodes function from repository`() {

        // given
        val repo = mockk<EpisodeRepository>(relaxed = true)
        val useCase = GetEpisodesUseCase(repo)

        // when
        useCase.invoke(
            params = Unit,
            scope = GlobalScope
        )

        // then
        coVerify { repo.getEpisodes() } // coVerify is a verify method for coroutines
    }

}