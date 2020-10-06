package pl.kaszmir.templatemvvm.fatures.characters.domain

import pl.kaszmir.templatemvvm.core.base.UseCase
import pl.kaszmir.templatemvvm.fatures.characters.data.repository.CharacterRepository
import pl.kaszmir.templatemvvm.fatures.characters.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {

    override suspend fun action(params: Unit): List<Character> = characterRepository.getCharacters()

}