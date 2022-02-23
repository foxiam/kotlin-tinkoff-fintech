package homework.lesson1

abstract class Vehicle {
    abstract val type: String
    abstract val manufacture: String
    abstract val model: String
    abstract val maxSpeed: Int
    protected abstract val consumption: Int

    fun basicSpecifications() {
        println("Type: $type")
        println("Manufacture: $manufacture")
        println("Model: $model")
        println("Max Speed: $maxSpeed")
    }

    protected fun driveCalc(distance: Float, amountPower: Float, message: String): Float {
        val calcDistance = distance / 100
        if (calcDistance * consumption <= amountPower)
            return calcDistance * consumption
        else
            println(message)
        return 0F
    }

    abstract fun allSpecifications()

    abstract fun drive(distance: Float)

    fun drive(distance: Int) = drive(distance.toFloat())

    abstract fun refilling()
}