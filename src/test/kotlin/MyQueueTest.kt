import homework.lesson4.queue.MyQueue
import io.mockk.spyk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

class MyQueueTest {

    @Test
    fun `checking add, size and poll methods`() {
        val queue = spyk(MyQueue<Int>())
        for(i in 1..3) queue.add(i)

        assertAll(
            { assertEquals(3, queue.size()) },
            { assertEquals(1, queue.poll()) },
            { assertEquals(2, queue.size()) },
            { assertEquals(2, queue.poll()) },
            { assertEquals(1, queue.size()) },
            { assertEquals(3, queue.poll()) }
        )
    }

    @Test
    fun `checking peek methods`() {
        val queue = spyk(MyQueue<Int>())
        for(i in 1..2) queue.add(i)

        assertAll(
            {assertEquals(1, queue.peek())},
            {assertEquals(1, queue.peek())},
        )
    }

    @Test
    fun `checking isEmpty methods`() {
        val queue = spyk(MyQueue<Int>())

        assertEquals(true, queue.isEmpty())
        queue.add(1)
        assertEquals(false, queue.isEmpty())
    }
}