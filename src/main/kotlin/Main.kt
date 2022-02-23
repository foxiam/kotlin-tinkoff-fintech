import homework.lesson1.Car
import homework.lesson1.ElectricCar
import homework.lesson1.Garage

fun main() {
    val volkswagen = Car("Volkswagen", "Polo", 250, 40, 12)
    val tesla = ElectricCar("Tesla", "Model 3", 300, 82,20)
    val vehicleList = listOf(volkswagen, tesla)

    vehicleList.forEach() {
        it.allSpecifications()
        it.drive(10)
        it.drive(1.5F)
    }

    println("Fuel left: ${volkswagen.getAmountGasoline()} л.")
    println("Battery power left: ${tesla.getBatteryPercentage()}%")
    println()

    val garage = Garage(volkswagen)
    garage.diagnostic()
    garage.refilingCar()
    println("Amount fuel ${(garage.vehicle as Car).getAmountGasoline()} л.")
    garage.driveOut()
    println("Car in the garage? ${!garage.isEmpty()}")
    garage.driveIn()
    println("Car in the garage? ${!garage.isEmpty()}")
}
