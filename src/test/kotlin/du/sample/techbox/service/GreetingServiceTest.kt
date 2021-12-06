package du.sample.techbox.service

import du.sample.techbox.module.greetingModule
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.get
import kotlin.test.assertEquals

internal class GreetingServiceTest: KoinTest {

    @Before
    fun setup () {
        startKoin {
            modules(listOf(greetingModule))
        }
    }
    @Test
    fun `given existing user when user exist then greet welcome` () {
        //arrange
        val greetingService: GreetingService = get()
        val testName = "john"

        //action
        val message = greetingService.greetings(testName)

        //assess
        assertEquals(String.format("Welcome back %s!", testName), message)
    }

    @After
    fun tearDown() {
        stopKoin()
    }
}