import homework.lesson4.stack.MyStack
import io.mockk.spyk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals


class MyStackTest {

    @Test
    fun `checking push, size and pop methods`() {
        val stack = spyk(MyStack<Int>())
        for(i in 1..3) stack.push(i)

        assertAll(
            { assertEquals(3, stack.size()) },
            { assertEquals(3, stack.pop()) },
            { assertEquals(2, stack.size()) },
            { assertEquals(2, stack.pop()) },
            { assertEquals(1, stack.size()) },
            { assertEquals(1, stack.pop()) }
        )
    }

    @Test
    fun `checking peek method`() {
        val stack = spyk(MyStack<Int>())
        for(i in 1..2) stack.push(i)

        assertAll(
            {assertEquals(2, stack.peek())},
            {assertEquals(2, stack.peek())},
        )
    }

    @Test
    fun `checking isEmpty method`() {
        val stack = spyk(MyStack<Int>())

        assertEquals(true, stack.isEmpty())
        stack.push(1)
        assertEquals(false, stack.isEmpty())
    }

}