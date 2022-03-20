package homework.lesson5

import java.util.function.BiPredicate

class Service(val listCar: List<Car>, ) {
    private val sequenceCar = listCar.asSequence()

    fun getSequenceDescriptionAndSort() = sequenceCar.sortedBy { it.price }
        .map {
            listOf(
                "Manufacture: ${it.manufacture}",
                "Model: ${it.model}",
                "Body type: ${it.bodyType}",
                "Price: ${"%.2f".format(
                    it.price / Currency.getExchangeRate()
                )} $",
                "Fuel Consumption: ${it.fuelConsumption} л."
            )
        }

    fun getSequenceGroupByBodyType() = sequenceCar.groupBy { it.bodyType }

    fun getSequenceOfThreeFilteredByPredicate(predicate: (Car) -> Boolean) = sequenceCar.filter(predicate).take(3)
}