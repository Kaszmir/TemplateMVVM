package pl.kaszmir.templatemvvm.fatures.characters.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.kaszmir.templatemvvm.fatures.characters.data.local.model.CharacterCached

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(vararg character: CharacterCached)

    @Query("SELECT * FROM CharacterCached")
    suspend fun getAllCharacters(): List<CharacterCached>

    @Query("SELECT * FROM CharacterCached WHERE id = :characterId")
    suspend fun getSingleCharacter(characterId: Int): CharacterCached

}