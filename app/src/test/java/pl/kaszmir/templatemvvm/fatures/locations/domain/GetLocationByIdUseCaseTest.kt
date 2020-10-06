package pl.kaszmir.templatemvvm.fatures.locations.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test
import pl.kaszmir.templatemvvm.fatures.locations.data.repository.LocationRepository

internal class GetLocationByIdUseCaseTest {

    @Test
    fun `when use case will be invoked than execute getLocation function from repository`() {
        // given
        val repo = mockk<LocationRepository>(relaxed = true)
        val useCase = GetLocationByIdUseCase(repo)

        // when
        useCase.invoke(
            params = 1,
            scope = GlobalScope
        )

        // then
        coVerify { repo.getLocation(1) } // coVerify is a verify method for coroutines
    }

}