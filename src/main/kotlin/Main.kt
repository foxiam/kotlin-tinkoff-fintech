import homework.lesson1.Car
import homework.lesson1.ElectricCar
import homework.lesson1.Garage

fun main() {
    val volkswagen = Car("Volkswagen", "Polo", 250, 8, 55)
    val tesla = ElectricCar("Tesla", "Model 3", 300, 20, 82)
    val vehicleList = listOf(volkswagen, tesla)

    vehicleList.forEach {
        it.allSpecifications()
        it.drive(10)
        it.drive(1.5F)
        it.drive(1000F)
        println()
    }

    println("Fuel left: ${volkswagen.getAmountGasoline()} л.")
    println("Battery power left: ${tesla.getBatteryPercentage()}%")
    println()

    val garage = Garage(volkswagen)

    garage.diagnostic()
    garage.refilingCar()
    println("Amount fuel ${(garage.getVehicle() as Car).getAmountGasoline()} л.")
    garage.driveOut()
    println("Car in the garage? ${!garage.isEmpty()}")
    garage.driveIn()
    println("Car in the garage? ${!garage.isEmpty()}")
}
