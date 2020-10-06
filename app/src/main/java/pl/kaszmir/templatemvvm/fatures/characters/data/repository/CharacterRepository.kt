package pl.kaszmir.templatemvvm.fatures.characters.data.repository

import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun getSingleCharacter(characterId: Int): Character
    suspend fun getMultipleCharactersById(charactersId: List<Int>): List<Character>
}