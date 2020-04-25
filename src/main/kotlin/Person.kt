data class Person(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val address: Address,
    val phoneNumber: List<PhoneNumber>
)
data class Address(
        val streetAddress: String,
        val city: String,
        val state: String,
        val postalCode: String
)
data class PhoneNumber(
        val type: String,
        val number: String
)