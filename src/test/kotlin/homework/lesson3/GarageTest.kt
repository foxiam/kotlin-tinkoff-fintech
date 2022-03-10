package homework.lesson3

import homework.lesson1.Car
import homework.lesson1.Garage
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import io.mockk.spyk
import io.mockk.mockk
import io.mockk.verify

class GarageTest {

    @Test
    fun `при вызове refilingCar(), бак должен быть полностью заправлен 1 раз`() {
        val car = spyk(Car("Volkswagen", "Polo", 250, 8, 55F), recordPrivateCalls = true)
        val garage = Garage(car)

        garage.refilingCar()

        assertEquals(55F, car.getAmountGasoline())
        verify(exactly = 1) { car.refilling() }
    }

    @Test
    fun `при вызове diagnostic(), дожны вызываться методы allSpecifications() и printAmountPower() 1 раз`() {
        val car = mockk<Car>(relaxUnitFun = true)
        val garage = Garage(car)

        garage.diagnostic()

        verify(exactly = 1) { car.allSpecifications() }
        verify(exactly = 1) { car.printAmountPower() }
    }
}