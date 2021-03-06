package pl.kaszmir.templatemvvm.core.di

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


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

}