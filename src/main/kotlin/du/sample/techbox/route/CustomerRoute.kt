package du.sample.techbox.route

import io.ktor.application.*
import io.ktor.routing.*

fun Application.customer() {

    routing {
        get("/customers") {
        }
    }
}