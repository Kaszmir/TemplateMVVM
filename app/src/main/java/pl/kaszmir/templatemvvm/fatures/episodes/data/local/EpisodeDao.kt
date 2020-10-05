package pl.kaszmir.templatemvvm.fatures.episodes.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.kaszmir.templatemvvm.fatures.episodes.data.local.model.EpisodeCached

@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEpisodes(vararg episode: EpisodeCached)

    @Query("SELECT * from EpisodeCached")
    suspend fun getEpisodes(): List<EpisodeCached>

    @Query("SELECT * from EpisodeCached where id = :episodeId")
    suspend fun getSingleEpisode(episodeId: Int): EpisodeCached
}