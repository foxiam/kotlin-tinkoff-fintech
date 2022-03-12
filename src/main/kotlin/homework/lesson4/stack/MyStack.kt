package homework.lesson4.stack

class MyStack<T> {

    private class StackElement<T>(val data: T, var next: StackElement<T>?)

    private var front: StackElement<T>? = null
    private var size = 0

    fun push(element: T) {
        front = StackElement(element, front)
        size++
    }

    fun pop(): T {
        if(front == null) throw NoSuchElementException()
        val data = front!!.data
        front = front?.next
        size--
        return data
    }

    fun peek(): T = front?.data ?: throw NoSuchElementException()

    fun size(): Int = size

    fun isEmpty(): Boolean = size == 0

}