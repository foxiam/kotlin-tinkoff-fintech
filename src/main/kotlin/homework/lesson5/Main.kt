package homework.lesson5

fun main() {
    val listCar = listOf(
        Car("Audi", "A6", BodyTypes.Sedan, 5590000, 10.9),
        Car("BMW", "M850i", BodyTypes.Coupe, 9990000, 8.7),
        Car("KIA", "K5 III", BodyTypes.Sedan, 2590000, 11.1),
        Car("Mercedes-Benz", "GLC Coupe 300 I", BodyTypes.SUV, 5250000, 9.7),
        Car("Volkswagen", "Tiguan II", BodyTypes.SUV, 2750000, 8.3),
    )
    val service = Service(listCar)

    println(service.getSequenceDescriptionAndSort().toList().joinToString("\n"))

    println(service.getSequenceGroupByBodyType().toList().joinToString("\n"))

    println(service.getSequenceOfThreeFilteredByPredicate { it.fuelConsumption > 8.5 }.joinToString("\n"))

}