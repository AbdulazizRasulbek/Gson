import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

val address = Address("21 2nd Street", "New York", "NY", "10021")
val phoneNumberList = listOf(
        PhoneNumber("mobile", "212 555-1234"),
        PhoneNumber("fax", "646 555-4567"))
val person = Person("John", "Smith", 25, address, phoneNumberList)
val gson = Gson()
fun main() {


}

fun personToJson() {
    val personJson = gson.toJson(person)
    println(personJson)
}

fun prettyPrinting() {
    val gsonBuilder = GsonBuilder()
    val prettyGson = gsonBuilder.setPrettyPrinting().create()
    val s = prettyGson.toJson(person)
    println(s)
}

fun personFromJson() {
    val personJson = gson.toJson(person)
    val personFromJson: Person = gson.fromJson(personJson, Person::class.java)
    println("${personFromJson.firstName} ${personFromJson.lastName}")
    println("${personFromJson.age} years old")
    println(personFromJson.address)
    println(personFromJson.phoneNumber)
    println(gson.toJson(phoneNumberList))
}

fun arrayFromJson() {
    val arrayJson = gson.toJson(phoneNumberList)
    val phoneNumbers: Array<PhoneNumber> = gson.fromJson(arrayJson, Array<PhoneNumber>::class.java)
}

fun listFromJson() {
    val phoneNumbersJson = gson.toJson(phoneNumberList)
    val type = object : TypeToken<List<PhoneNumber>>() {}.type
    val list: List<PhoneNumber> = gson.fromJson(phoneNumbersJson, type)
}