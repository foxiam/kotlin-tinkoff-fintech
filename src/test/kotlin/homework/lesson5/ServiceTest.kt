package homework.lesson5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ServiceTest {
    private val listCar = listOf(
        Car("Audi", "A6", "Sedan", 5590000, 10.9),
        Car("BMW", "M850i", "Coupe", 9990000, 8.7),
        Car("KIA", "K5 III", "Sedan", 2590000, 11.1),
        Car("Mercedes-Benz", "GLC Coupe 300 I", "SUV", 5250000, 9.7),
        Car("Volkswagen", "Tiguan II", "SUV", 2750000, 8.3)
    )

    private val service = Service(listCar)

    @Test
    fun `price sort test`() {
        val sortedCar = listOf(listCar[2], listCar[4], listCar[3], listCar[0], listCar[1])
            .map { makeDescription(it) }

        assertEquals(sortedCar, service.getDescriptionAndSort())
    }

    @Test
    fun `test group by body type`() {
        val groupCar = mapOf(
            "Sedan" to listOf(listCar[0], listCar[2]),
            "Coupe" to listOf(listCar[1]),
            "SUV" to listOf(listCar[3], listCar[4])
        )

        assertEquals(groupCar, service.getGroupByBodyType())
    }

    @Test
    fun `body type filter test with return first 3 elements`() {
        var fourSameBodyType = listOf(
            listCar[0],
            listCar[2],
            Car("a","b","Sedan", 1, 1.0),
            Car("c","d","Sedan", 2, 2.0),
            listCar[3]
        )

        val serviceForTestFilter = Service(fourSameBodyType)

        var filteredCar = fourSameBodyType.subList(0, 3)

        assertEquals(filteredCar, serviceForTestFilter.getThreeFiltered { it.bodyType == "Sedan" })
    }

    @Test
    fun `fuel consumption filter test with return first 3 elements`() {
        var filteredCar = listOf(listCar[0], listCar[1], listCar[3])

        assertEquals(filteredCar, service.getThreeFiltered { it.fuelConsumption < 11})
    }
}