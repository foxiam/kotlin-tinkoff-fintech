package homework.lesson5

abstract class Currency {
    companion object {
        private const val exchangeRate  = 100.0
        fun getExchangeRate(): Double = exchangeRate
    }
}