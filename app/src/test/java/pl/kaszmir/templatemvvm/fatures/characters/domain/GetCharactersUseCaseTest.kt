package pl.kaszmir.templatemvvm.fatures.characters.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test
import pl.kaszmir.templatemvvm.fatures.characters.data.repository.CharacterRepository

internal class GetCharactersUseCaseTest {

    @Test
    fun `when use case will be invoked than execute getCharacters function from repository`() {

        // given
        val repo = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetCharactersUseCase(repo)

        // when
        useCase.invoke(
            params = Unit,
            scope = GlobalScope
        )

        // then
        coVerify { repo.getCharacters() } // coVerify is a verify method for coroutines
    }

}