package pl.kaszmir.templatemvvm.fatures.episodes.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test
import pl.kaszmir.templatemvvm.fatures.episodes.EpisodeRepository

internal class GetSingleEpisodeUseCaseTest {

    @Test
    fun `when use case will be invoked than execute getSingleEpisode function from repository`() {

        // given
        val repo = mockk<EpisodeRepository>(relaxed = true)
        val useCase = GetSingleEpisodeUseCase(repo)

        // when
        useCase.invoke(
            params = 1,
            scope = GlobalScope
        )

        // then
        coVerify { repo.getSingleEpisode(1) } // coVerify is a verify method for coroutines
    }

}