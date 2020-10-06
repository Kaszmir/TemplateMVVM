package pl.kaszmir.templatemvvm.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.kaszmir.templatemvvm.core.network.NetworkStateProvider
import pl.kaszmir.templatemvvm.core.network.NetworkStateProviderImpl


const val GRID_COLUMN_COUNT = 2

val appModule = module {

    /**
     * [LinearLayoutManager] instance to display [RecyclerView] items as a vertical list
     */

    factory {
        LinearLayoutManager(androidContext())
    }


    /**
     * [GridLayoutManager] instance to display [RecyclerView] items in grid
     */

    factory {
        GridLayoutManager(
            androidContext(),
            GRID_COLUMN_COUNT
        )
    }


    /**
     * [RecyclerView] default item decoration [DividerItemDecoration]
     */

    factory {
        DividerItemDecoration(
            androidContext(),
            LinearLayoutManager.VERTICAL
        )
    }

    /**
     * Connectivity Manager
     */

    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }

}