package homework.lesson8

import java.util.concurrent.LinkedBlockingQueue

class WorkerThread(
    private val queueTask: LinkedBlockingQueue<Runnable>
) : Thread() {

    var isStopped = false

    override fun run() {
        while (true) {
            var task: Runnable? = null
            synchronized(queueTask) {
                if (queueTask.isEmpty()) {
                    try {
                        (queueTask as Object).wait()
                    } catch (e: InterruptedException) {
                        isStopped = true
                    }
                }
                if (!isStopped) {
                    task = queueTask.poll()
                }
            }
            if (isStopped)
                break
            task!!.run()
        }
    }

    @Synchronized
    fun stopWorkerThread(): Boolean {
        isStopped = true
        if (this.state == State.WAITING) {
            this.interrupt()
            return true
        }
        return false
    }
}