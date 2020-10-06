package pl.kaszmir.templatemvvm.fatures.characters.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test
import pl.kaszmir.templatemvvm.fatures.characters.data.repository.CharacterRepository

internal class GetMultipleCharactersByIdUseCaseTest {

    @Test
    fun `when use case will be invoked than execute getMultipleCharactersById function from repository`() {

        // given
        val repo = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetMultipleCharactersByIdUseCase(repo)
        val params = listOf(1, 2, 3)

        // when
        useCase.invoke(
            params = params,
            scope = GlobalScope
        )

        // then
        coVerify { repo.getMultipleCharactersById(params) } // coVerify is a verify method for coroutines
    }

}