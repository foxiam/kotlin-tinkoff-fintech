package homework.lesson1

class Car(override val manufacture: String, override val model: String,
          override val maxSpeed: Int, private val tankVolume: Int, private val consumption : Int) : Vehicle {
    override val type = "Car"
    private var amountFuel = tankVolume.toFloat()

    override fun allSpecifications() {
        basicSpecifications()
        println("Tank volume: $tankVolume")
        println()
    }
    override fun drive(distance : Float) {
        val calcDistance = distance / 100
        if(calcDistance * consumption <= amountFuel)
            amountFuel -= calcDistance * consumption
        else
            println("Not enough fuel")
    }
    override fun drive(distance : Int) = drive(distance.toFloat())
    override fun refilling() {
        amountFuel = tankVolume.toFloat()
    }
    fun getAmountGasoline(): Float {
        return amountFuel
    }

}