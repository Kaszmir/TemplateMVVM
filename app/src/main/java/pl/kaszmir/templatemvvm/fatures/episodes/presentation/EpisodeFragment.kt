package pl.kaszmir.templatemvvm.fatures.episodes.presentation

import androidx.lifecycle.observe
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.kaszmir.templatemvvm.R
import pl.kaszmir.templatemvvm.core.base.BaseFragment


class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.episode_fragment) {

    override val viewModel: EpisodeViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        // init all views
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
        // handle idle state here
    }

    override fun onPendingState() {
        super.onPendingState()
        // handle pending state here
    }

    /**
     * Private functions
     */

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            // display episodes
        }
    }
}