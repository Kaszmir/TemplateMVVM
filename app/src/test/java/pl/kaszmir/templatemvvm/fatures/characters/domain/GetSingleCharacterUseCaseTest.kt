package pl.kaszmir.templatemvvm.fatures.characters.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test
import pl.kaszmir.templatemvvm.fatures.characters.data.repository.CharacterRepository

internal class GetSingleCharacterUseCaseTest {

    @Test
    fun `when use case will be invoked than execute getSingleCharacter() function from repository`() {

        // given
        val repo = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetSingleCharacterUseCase(repo)

        // when
        useCase.invoke(
            params = 1,
            scope = GlobalScope
        )

        // then
        coVerify { repo.getSingleCharacter(1) } // coVerify is a verify method for coroutines
    }

}