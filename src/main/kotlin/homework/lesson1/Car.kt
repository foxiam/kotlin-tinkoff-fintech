package homework.lesson1

class Car(
    override val manufacture: String,
    override val model: String,
    override val maxSpeed: Int,
    override val consumption: Int,
    private val tankVolume: Int
) : Vehicle() {

    override val type = "Car"
    private var amountGasoline = tankVolume.toFloat()

    override fun allSpecifications() {
        basicSpecifications()
        println("Tank volume: $tankVolume")
        println()
    }

    override fun drive(distance : Float) {
        amountGasoline -= driveCalc(distance, amountGasoline, "Not enough gasoline")
    }

    override fun refilling() {
        amountGasoline = tankVolume.toFloat()
    }

    fun getAmountGasoline(): Float {
        return amountGasoline
    }
}