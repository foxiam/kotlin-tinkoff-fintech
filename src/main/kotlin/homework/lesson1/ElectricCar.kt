package homework.lesson1

class ElectricCar(
    override val manufacture: String,
    override val model: String,
    override val maxSpeed: Int,
    override val consumption: Int,
    private val batteryCapacity: Int,
) : Vehicle() {

    override val type = "Electric Car"
    private var batteryPower = batteryCapacity.toFloat()

    override fun allSpecifications() {
        basicSpecifications()
        println("Battery capacity: $batteryCapacity")
        println()
    }

    override fun drive(distance : Float) {
        batteryPower -= driveCalc(distance, batteryPower, "Not enough battery power")
    }

    override fun refilling() {
        batteryPower = batteryCapacity.toFloat()
    }

    fun getBatteryPower(): Float {
        return batteryPower
    }

    fun getBatteryPercentage(): Float {
        return (batteryPower / batteryCapacity) * 100
    }
}