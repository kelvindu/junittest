package du.sample.techbox.route

import du.sample.techbox.handler.CustomerHandler
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
import org.koin.ktor.ext.get

fun Application.customer() {

    install(DefaultHeaders)

    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    routing {
        val handler: CustomerHandler = get()
        get("/customers", handler.get)

        get("/customer/{id}", handler.getById)
    }
}