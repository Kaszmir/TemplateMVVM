package pl.kaszmir.templatemvvm.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.kaszmir.templatemvvm.fatures.episodes.data.local.EpisodeDao
import pl.kaszmir.templatemvvm.fatures.episodes.data.local.model.EpisodeCached

const val databaseName = "templatemvvm-db"

@Database(entities = [EpisodeCached::class], version = 1)
@TypeConverters(
    ListConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun episodeDao(): EpisodeDao
}