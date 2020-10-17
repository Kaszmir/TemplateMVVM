package pl.kaszmir.templatemvvm.fatures.episodes.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.Test
import pl.kaszmir.templatemvvm.core.base.UIState
import pl.kaszmir.templatemvvm.fatures.episodes.domain.GetEpisodesUseCase
import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Episode
import pl.kaszmir.templatemvvm.fatures.mock.mock
import pl.kaszmir.templatemvvm.fatures.utils.ViewModelTest
import pl.kaszmir.templatemvvm.fatures.utils.getOrAwaitValue
import pl.kaszmir.templatemvvm.fatures.utils.observeForTesting

internal class EpisodeViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN episodes liveData is observed THEN set Pending UIState test`() {
        // given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase)

        // when
        viewModel.episodes.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Pending
    }

    @Test
    fun `WHEN episodes liveData is observed THEN invoke use case to get episodes`() {
        // given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase)

        // when
        viewModel.episodes.observeForTesting()

        // then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN episodes liva data is observed liveData is observed THEN set idle state AND set result in live data`() {

        // given
        val episodes = listOf(Episode.mock(), Episode.mock(), Episode.mock())
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.success(episodes))
            }
        }

        val viewModel = EpisodeViewModel(useCase)

        // when
        viewModel.episodes.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        viewModel.episodes.getOrAwaitValue().forEachIndexed { index, episodeDisplayable ->
            val episode = episodes[index]
            episodeDisplayable.name shouldBe episode.name
            episodeDisplayable.airDate shouldBe episode.airDate
            episodeDisplayable.url shouldBe episode.url
            episodeDisplayable.characters shouldBe episode.characters
            episodeDisplayable.id shouldBe episode.id
            episodeDisplayable.episodeCode shouldBe episode.episodeCode
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN episodes liva data is observed liveData is observed THEN set idle state AND set error message in live data`() {
        // given
        val error = Throwable("Test error")
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) }.answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.failure(error))
            }
        }

        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase)

        // when
        viewModel.message.observeForever(observer)
        viewModel.episodes.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        verify { observer.onChanged(error.message) }
    }

}