package du.sample.techbox.handler

import du.sample.techbox.service.GreetingService
import io.ktor.application.*
import io.ktor.response.*

class GreetingHandler(private val greetingService: GreetingService) {
    val greet: Handler = {
        val name:String = if(call.request.queryParameters["name"] != null) call.request.queryParameters["name"].toString() else "John"
        call.respondText(greetingService.greetings(name))
    }
}