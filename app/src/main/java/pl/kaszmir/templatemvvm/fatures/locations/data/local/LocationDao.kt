package pl.kaszmir.templatemvvm.fatures.locations.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.kaszmir.templatemvvm.fatures.locations.data.local.model.LocationCached

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(vararg location: LocationCached)

    @Query("SELECT * FROM LocationCached")
    suspend fun getAllLocations(): List<LocationCached>

    @Query("SELECT * FROM LocationCached WHERE id = :locationId")
    suspend fun getSingleLocation(locationId: Int): LocationCached

}