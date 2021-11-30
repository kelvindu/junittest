package du.sample.techbox.route

import du.sample.techbox.handler.GreetingHandler
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.get

fun Application.greeting() {

    // Starting point for a Ktor app:
    routing {
        val greetingHandler:GreetingHandler = get()
        get("/greeting") {
            val name:String = if(call.request.queryParameters["name"] != null) call.request.queryParameters["name"].toString() else "John"
            call.respondText(greetingHandler.greetings(name))
        }
    }
}
