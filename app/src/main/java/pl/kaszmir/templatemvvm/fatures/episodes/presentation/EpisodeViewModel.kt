package pl.kaszmir.templatemvvm.fatures.episodes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import pl.kaszmir.templatemvvm.core.base.BaseViewModel
import pl.kaszmir.templatemvvm.core.base.UIState
import pl.kaszmir.templatemvvm.fatures.episodes.domain.GetEpisodesUseCase
import pl.kaszmir.templatemvvm.fatures.episodes.domain.model.Episode
import pl.kaszmir.templatemvvm.fatures.episodes.presentation.model.EpisodeDisplayable

class EpisodeViewModel(
    private val getEpisodesUseCase: GetEpisodesUseCase
) : BaseViewModel() {

    private val _episodes by lazy {
        MutableLiveData<List<Episode>>()
            .also { getEpisodes(it) }
    }

    val episodes: LiveData<List<EpisodeDisplayable>> by lazy {
        _episodes.map { episodes ->
            episodes.map { EpisodeDisplayable(it) }
        }
    }


    /**
     * Private function
     */

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<Episode>>) {
        setUiState(UIState.Pending)
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setUiState(UIState.Idle) // set ui state
            result.onSuccess { episodeLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}