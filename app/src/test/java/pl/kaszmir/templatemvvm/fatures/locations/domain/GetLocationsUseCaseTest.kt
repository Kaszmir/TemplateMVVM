package pl.kaszmir.templatemvvm.fatures.locations.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test
import pl.kaszmir.templatemvvm.fatures.locations.data.repository.LocationRepository

class GetLocationsUseCaseTest {

    @Test
    fun `when use case will be invoked than execute getLocations function from repository`() {
        // given
        val repo = mockk<LocationRepository>(relaxed = true)
        val useCase = GetLocationsUseCase(repo)

        // when
        useCase.invoke(
            params = Unit,
            scope = GlobalScope
        )

        // then
        coVerify { repo.getLocations() } // coVerify is a verify method for coroutines
    }
}