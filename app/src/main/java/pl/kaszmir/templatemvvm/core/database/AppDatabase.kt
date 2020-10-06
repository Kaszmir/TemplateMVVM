package pl.kaszmir.templatemvvm.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.kaszmir.templatemvvm.fatures.characters.data.local.CharacterDao
import pl.kaszmir.templatemvvm.fatures.characters.data.local.model.CharacterCached
import pl.kaszmir.templatemvvm.fatures.characters.data.local.model.LocationConverter
import pl.kaszmir.templatemvvm.fatures.characters.data.local.model.OriginConverter
import pl.kaszmir.templatemvvm.fatures.episodes.data.local.EpisodeDao
import pl.kaszmir.templatemvvm.fatures.episodes.data.local.model.EpisodeCached
import pl.kaszmir.templatemvvm.fatures.locations.data.local.LocationDao
import pl.kaszmir.templatemvvm.fatures.locations.data.local.model.LocationCached

const val databaseName = "templatemvvm-db"

@Database(
    entities = [EpisodeCached::class, CharacterCached::class, LocationCached::class],
    version = 1
)
@TypeConverters(
    ListConverter::class,
    OriginConverter::class,
    LocationConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun episodeDao(): EpisodeDao
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
}