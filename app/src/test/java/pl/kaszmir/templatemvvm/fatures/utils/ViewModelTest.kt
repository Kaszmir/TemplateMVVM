package pl.kaszmir.templatemvvm.fatures.utils

import androidx.arch.core.executor.ArchTaskExecutor
import org.junit.After
import org.junit.Before

open class ViewModelTest {

    @Before
    fun setUp() {
        ArchTaskExecutor.getInstance().setDelegate(FakeMainThreadExecutor)
    }

    @After
    fun tearDown() {
        ArchTaskExecutor.getInstance().setDelegate(null)
    }

}