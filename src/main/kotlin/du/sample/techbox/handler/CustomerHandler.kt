package du.sample.techbox.handler

import du.sample.techbox.dto.Customer
import io.ktor.application.*
import io.ktor.response.*

class CustomerHandler {

    val getById: Handler = {
        val customerID = call.parameters["id"]
        val customerStub = Customer(
            "1",
            "John Smith",
            21,
            "Student")

        call.respond(if(customerStub.id == customerID) customerStub else Customer(null, null, null, null))
    }

    val get: Handler = {
        val customerStubs = listOf(
            Customer(
                "1",
                "John Smith",
                20,
                "Student"),
            Customer(
                "2",
                "Foo Bar",
                24,
                "Employee")
        )

        call.respond(customerStubs)
    }

}