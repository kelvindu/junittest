package du.sample.techbox.module

import du.sample.techbox.handler.CustomerHandler
import du.sample.techbox.handler.GreetingHandler
import du.sample.techbox.service.GreetingService
import org.koin.dsl.module

val greetingModule = module {
    single { GreetingService() }
    single { GreetingHandler(get()) }

    single { CustomerHandler() }
}