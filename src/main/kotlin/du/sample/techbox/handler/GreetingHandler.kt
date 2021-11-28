package du.sample.techbox.handler

class GreetingHandler {

    val existingCustomers = listOf("john", "laura", "felix")

    fun greetings (name: String): String {
        val greetings: String
        if (signin(name)) {
            greetings = String.format("Welcome back %s!", name)
        } else {
            greetings = String.format("Hello %s!", name)
        }
        return greetings
    }

    fun signin (name: String) = existingCustomers.contains(name)
}