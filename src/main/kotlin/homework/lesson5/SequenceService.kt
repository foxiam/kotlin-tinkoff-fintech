package homework.lesson5

class SequenceService(private val listCar: List<Car>, ) {
    private val sequenceCar = listCar.asSequence()

    fun getDescriptionAndSort() = sequenceCar.sortedBy { it.price }
        .map { makeDescription(it) }

    fun getGroupByBodyType() = sequenceCar.groupBy { it.bodyType }

    fun getThreeFiltered(predicate: (Car) -> Boolean) = sequenceCar.filter(predicate).take(3)
}