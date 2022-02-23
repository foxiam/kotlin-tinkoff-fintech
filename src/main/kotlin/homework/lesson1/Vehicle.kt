package homework.lesson1

interface Vehicle {
    val type: String
    val manufacture: String
    val model: String
    val maxSpeed : Int

    fun basicSpecifications() {
        println("Type: $type")
        println("Manufacture: $manufacture")
        println("Model: $model")
        println("Max Speed: $maxSpeed")
    }
    fun allSpecifications()
    fun drive(distance : Float)
    fun drive(distance : Int)
    fun refilling()
}