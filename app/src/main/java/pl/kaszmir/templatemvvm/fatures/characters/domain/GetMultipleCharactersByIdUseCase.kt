package pl.kaszmir.templatemvvm.fatures.characters.domain

import pl.kaszmir.templatemvvm.core.base.UseCase
import pl.kaszmir.templatemvvm.fatures.characters.CharacterRepository
import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Character

class GetMultipleCharactersByIdUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, List<Int>>() {

    override suspend fun action(params: List<Int>): List<Character> =
        characterRepository.getMultipleCharactersById(params)
}