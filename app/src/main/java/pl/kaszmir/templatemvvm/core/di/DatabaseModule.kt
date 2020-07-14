package pl.kaszmir.templatemvvm.core.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.kaszmir.templatemvvm.core.app.AppDatabase
import pl.kaszmir.templatemvvm.core.app.databaseName

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            databaseName
        ).build()
    }

}