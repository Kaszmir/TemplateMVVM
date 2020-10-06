package pl.kaszmir.templatemvvm.fatures.locations.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test
import pl.kaszmir.templatemvvm.fatures.locations.data.repository.LocationRepository

internal class GetMultipleLocationsByIdUseCaseTest {

    @Test
    fun `when use case will be invoked than execute getMultipleLocationsById function from repository`() {
        // given
        val repo = mockk<LocationRepository>(relaxed = true)
        val useCase = GetMultipleLocationsByIdUseCase(repo)
        val params = listOf(1, 3, 3)

        // when
        useCase.invoke(
            params = params,
            scope = GlobalScope
        )

        // then
        coVerify { repo.getMultipleLocationsById(params) } // coVerify is a verify method for coroutines
    }
}