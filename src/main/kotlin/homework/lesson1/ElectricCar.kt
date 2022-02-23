package homework.lesson1

class ElectricCar(override val manufacture: String, override val model: String,
                  override val maxSpeed: Int, private val batteryCapacity: Int, private val consumption : Int) :
    Vehicle {
    override val type = "Electric Car"
    private var batteryPower = batteryCapacity.toFloat()

    override fun allSpecifications() {
        basicSpecifications()
        println("Battery capacity: $batteryCapacity")
        println()
    }
    override fun drive(distance : Float) {
        val calcDistance = distance / 100
        if(calcDistance * consumption <= batteryPower)
            batteryPower -= calcDistance * consumption
        else
            println("Not enough battery power")
    }
    override fun drive(distance : Int) = drive(distance.toFloat())
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