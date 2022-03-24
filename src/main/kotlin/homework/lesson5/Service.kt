package homework.lesson5

class Service(private val listCar: List<Car>) {

    fun getDescriptionAndSort() = listCar.sortedBy { it.price }
        .map { makeDescription(it) }

    fun getGroupByBodyType() = listCar.groupBy { it.bodyType }

    fun getThreeFiltered(predicate: (Car) -> Boolean) = listCar.filter(predicate).take(3)
}