package homework.lesson1

class Garage(var vehicle: Vehicle) {
    private var empty: Boolean = false
    fun refilingCar() {
        if(!empty) vehicle.refilling()
        else println("Car is not in the garage")
        println()
    }
    fun diagnostic() {
        println("---Diagnostic---")
        vehicle.allSpecifications()
        if(vehicle is ElectricCar) println("Amount battery power ${(vehicle as ElectricCar).getBatteryPower()} Wh.")
        else if(vehicle is Car) println("Amount fuel ${(vehicle as Car).getAmountGasoline()} л.")
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
}