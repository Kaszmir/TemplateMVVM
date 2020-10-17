package pl.kaszmir.templatemvvm.fatures.episodes.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.kaszmir.templatemvvm.fatures.episodes.data.repository.EpisodeRepository
import pl.kaszmir.templatemvvm.fatures.episodes.data.repository.EpisodeRepositoryImpl
import pl.kaszmir.templatemvvm.fatures.episodes.domain.GetEpisodesUseCase
import pl.kaszmir.templatemvvm.fatures.episodes.presentation.EpisodeFragment
import pl.kaszmir.templatemvvm.fatures.episodes.presentation.EpisodeViewModel

val episodeModule = module {

    // data
    factory<EpisodeRepository> {
        EpisodeRepositoryImpl(get(), get(), get())
    }

    // domain
    factory { GetEpisodesUseCase(get()) }

    // presentation
    viewModel { EpisodeViewModel(get()) }
    factory { EpisodeFragment() }
}