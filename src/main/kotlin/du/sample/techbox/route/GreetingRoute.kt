package du.sample.techbox.route

import du.sample.techbox.handler.GreetingHandler
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.get

fun Application.greeting() {

    // Starting point for a Ktor app:
    routing {
        val greetingHandler:GreetingHandler = get()
        get("/greeting") {
            call.respondText(greetingHandler.greetings("John"))
        }
    }
}