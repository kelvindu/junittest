package du.sample.techbox.route

import du.sample.techbox.handler.GreetingHandler
import io.ktor.application.*
import io.ktor.routing.*
import org.koin.ktor.ext.get

fun Application.greeting() {

    // Starting point for a Ktor app:
    routing {
        val handler: GreetingHandler = get()
        get("/greeting", handler.greet)
    }
}
