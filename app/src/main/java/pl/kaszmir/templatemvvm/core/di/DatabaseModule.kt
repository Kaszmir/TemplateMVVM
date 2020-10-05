package pl.kaszmir.templatemvvm.core.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.kaszmir.templatemvvm.core.database.AppDatabase
import pl.kaszmir.templatemvvm.core.database.databaseName

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            databaseName
        ).build()
    }

    single { get<AppDatabase>().episodeDao() }

}