package du.sample.techbox.module

import du.sample.techbox.handler.GreetingHandler
import org.koin.dsl.module

val greetingModule = module {
    single { GreetingHandler() }
}