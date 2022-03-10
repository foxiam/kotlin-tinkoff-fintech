package homework.lesson1

class Garage(private val vehicle: Vehicle) {

    private var empty: Boolean = false

    fun refilingCar() {
        if (!empty) vehicle.refilling()
        else println("Car is not in the garage")
        println()
    }

    fun diagnostic() {
        println("---Diagnostic---")
        vehicle.allSpecifications()
        vehicle.printAmountPower()
        println("----------------")
    }

    fun isEmpty(): Boolean {
        return empty
    }

    fun driveIn() {
        empty = false
    }

    fun driveOut() {
        empty = true
    }

    fun getVehicle(): Vehicle {
        return vehicle
    }
}