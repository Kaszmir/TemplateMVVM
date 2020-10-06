package pl.kaszmir.templatemvvm.fatures.episodes.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test
import pl.kaszmir.templatemvvm.fatures.episodes.data.repository.EpisodeRepository

internal class GetMultipleEpisodesByIdUseCaseTest {

    @Test
    fun `when use case will be invoked than execute getMultipleEpisodesById function from repository`() {

        // given
        val repo = mockk<EpisodeRepository>(relaxed = true)
        val useCase = GetMultipleEpisodesByIdUseCase(repo)
        val params = listOf(1, 2, 3)

        // when
        useCase.invoke(
            params = params,
            scope = GlobalScope
        )

        // then
        coVerify { repo.getMultipleEpisodesById(params) } // coVerify is a verify method for coroutines
    }

}