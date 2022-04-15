package homework.lesson8

import  java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue

class ThreadPool(
    numberThreads: Int
) : Executor {

    private val workerThreadList = mutableListOf<WorkerThread>()

    private val queueTask = LinkedBlockingQueue<Runnable>()

    init {
        if (numberThreads <= 0)
            throw IllegalArgumentException("number of threads must be greater than 0")
        for (i in 1..numberThreads) {
            val thread = WorkerThread(queueTask)
            workerThreadList.add(thread)
            thread.start()
        }
    }

    @Synchronized
    override fun execute(command: Runnable) {
        synchronized(queueTask) {
            queueTask.add(command)
            (queueTask as Object).notify()
        }
    }

    @Synchronized
    fun shutdown() {
        workerThreadList.any { it.stopWorkerThread() }
    }
}