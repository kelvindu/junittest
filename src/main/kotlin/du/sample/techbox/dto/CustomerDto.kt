package du.sample.techbox.dto

import kotlinx.serialization.Serializable

@Serializable
data class Customer (
    val id: String?,
    val name: String?,
    val age: Int?,
    val job: String?
)