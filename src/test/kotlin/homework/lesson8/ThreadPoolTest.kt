package homework.lesson8

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ThreadsTest {

    @Test
    fun `thread pool test`() {
        val array = mutableListOf<Int>()

        assertDoesNotThrow {
            val threadPool = ThreadPool(8)
            for (i in 0 until 8) {
                threadPool.execute {
                    array.add(i)
                }
            }
            threadPool.shutdown()
        }
        for (i in 0 until 8) {
            assertEquals(i, array[i])
        }
    }

    @Test
    fun `check for throwing an exception when the number of threads is 0`() {
        val result = assertThrows<IllegalArgumentException> {
            ThreadPool(0)
        }
        assertEquals("number of threads must be greater than 0", result.message)
    }
}