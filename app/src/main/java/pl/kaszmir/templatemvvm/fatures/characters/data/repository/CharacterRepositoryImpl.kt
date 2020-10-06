package pl.kaszmir.templatemvvm.fatures.characters.data.repository

import pl.kaszmir.templatemvvm.core.api.remote.RickAndMortyApi
import pl.kaszmir.templatemvvm.core.network.NetworkStateProvider
import pl.kaszmir.templatemvvm.fatures.characters.data.local.CharacterDao
import pl.kaszmir.templatemvvm.fatures.characters.data.local.model.CharacterCached
import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Character

class CharacterRepositoryImpl(
    private val api: RickAndMortyApi,
    private val dao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider
) : CharacterRepository {


    /**
     * [CharacterRepository] functions
     */

    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getAllCharactersFromRemote()
                .also { saveCharactersLocal(it) }
        } else {
            dao.getAllCharacters()
                .map { it.toCharacter() }
        }
    }


    override suspend fun getSingleCharacter(characterId: Int): Character {
        return if (networkStateProvider.isNetworkAvailable()) {
            api.getSingleCharacter(characterId).toCharacter()
        } else {
            dao.getSingleCharacter(characterId).toCharacter()
        }
    }

    override suspend fun getMultipleCharactersById(charactersId: List<Int>): List<Character> {
        return api.getMultipleCharactersById(charactersId).result.map { it.toCharacter() }
    }


    /**
     * Private functions
     */

    private suspend fun getAllCharactersFromRemote(): List<Character> {
        return api.getCharacters()
            .result
            .map { it.toCharacter() }
    }

    private suspend fun saveCharactersLocal(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
            .let { dao.saveCharacters(*it) }
    }

}