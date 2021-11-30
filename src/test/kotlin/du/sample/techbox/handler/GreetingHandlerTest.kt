package du.sample.techbox.handler

import du.sample.techbox.module.greetingModule
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.get
import kotlin.test.assertEquals

internal class GreetingHandlerTest: KoinTest {

    @Before
    fun setup () {
        startKoin {
            modules(listOf(greetingModule))
        }
    }
    @Test
    fun `given existing user when user exist then greet welcome` () {
        //arrange
        val greetingHandler: GreetingHandler = get()
        val testName = "john"

        //action
        val message = greetingHandler.greetings(testName)

        //assess
        assertEquals(String.format("Welcome back %s!", testName), message)
    }

    @After
    fun tearDown() {
        stopKoin()
    }
}