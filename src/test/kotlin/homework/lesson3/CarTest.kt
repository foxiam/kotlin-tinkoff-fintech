package homework.lesson3

import homework.lesson1.Car
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CarTest {

    @Test
    fun `Проверка коректоности расхода топлива на 100 км` (){
        val car = Car("Volkswagen", "Polo", 250, 8, 55F)

        car.drive(100)

        assertEquals(47F, car.getAmountGasoline())
    }

    @Test
    fun `Проверка коректности расхода топлива на 687,5 км`(){
        val car = Car("Volkswagen", "Polo", 250, 8, 55F)

        car.drive(687.5F)

        assertEquals(0F, car.getAmountGasoline())
    }

    @Test
    fun `Проверка коректности расхода топлива на 0 км`(){
        val car = Car("Volkswagen", "Polo", 250, 8, 55F)

        car.drive(0)

        assertEquals(55F, car.getAmountGasoline())
    }

}