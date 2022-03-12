package homework.lesson4.queue

class MyQueue<T> {

    private class QueueElement<T>(val data: T, var next: QueueElement<T>? = null)

    private var front: QueueElement<T>? = null
    private var rear: QueueElement<T>? = null
    private var size = 0

    fun add(e: T) {
        if(size == 0) {
            front = QueueElement(e)
            rear = front
        }
        else {
            rear?.next = QueueElement(e)
            rear = rear?.next
        }
        size++
    }

    fun element(): T = peek() ?: throw NoSuchElementException()

    fun remove(): T = poll() ?: throw NoSuchElementException()

    fun peek(): T? = front?.data

    fun poll(): T? {
        val data = front?.data
        front = front?.next
        size--
        return data
    }

    fun offer(e: T): Boolean {
        add(e)
        return true
    }

    fun size(): Int = size

    fun isEmpty(): Boolean = size == 0

}