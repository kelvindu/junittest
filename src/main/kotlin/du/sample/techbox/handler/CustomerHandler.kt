package du.sample.techbox.handler

import du.sample.techbox.dto.Customer
import du.sample.techbox.service.CustomerService
import io.ktor.application.*
import io.ktor.response.*

class CustomerHandler(customerService: CustomerService) {

    val getById: Handler = {
        val customer = customerService.getCustomerById(call.parameters["id"].toString())

        call.respond(customer)
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