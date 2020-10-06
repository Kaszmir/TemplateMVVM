package pl.kaszmir.templatemvvm.fatures.characters.domain

import pl.kaszmir.templatemvvm.core.base.UseCase
import pl.kaszmir.templatemvvm.fatures.characters.data.repository.CharacterRepository
import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Character

class GetSingleCharacterUseCase(private val characterRepository: CharacterRepository) :
    UseCase<Character, Int>() {
    override suspend fun action(params: Int): Character =
        characterRepository.getSingleCharacter(params)
}