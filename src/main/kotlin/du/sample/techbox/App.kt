package du.sample.techbox

import du.sample.techbox.module.customerModule
import du.sample.techbox.module.greetingModule
import du.sample.techbox.route.customer
import du.sample.techbox.route.greeting
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.core.context.startKoin

fun main() {

    startKoin {
        modules(listOf(greetingModule, customerModule))
    }
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        greeting()
        customer()
    }.start(wait = true)
}
