package du.sample.techbox.handler

import du.sample.techbox.dto.Customer
import du.sample.techbox.module.customerModule
import du.sample.techbox.route.customer
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import kotlin.test.assertEquals


internal class CustomerHandlerTest: KoinTest {

    @Before
    fun setup () {
        startKoin {
            modules(listOf(customerModule))
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `given customer ID is 1 then return customer of ID 1`(): Unit = withTestApplication(Application::customer) {
        //arrange
        val customerID = "1"

        //action
        with(handleRequest(HttpMethod.Get, String.format("/customer/%s", customerID)) {
            val customerStub = Customer(
                "1",
                "John Smith",
                21,
                "Student")
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            setBody(Json.encodeToString(customerStub))
        }) {
            val responseBody = response.content?.let { Json.decodeFromString<Customer>(it) }
            //assess
            assertEquals(HttpStatusCode.OK, response.status())
            assertEquals(customerID, responseBody?.id)
        }
    }
}