package homework.lesson13.service

import homework.lesson13.model.EventModel
import org.springframework.stereotype.Service

@Service
class EmailProcessor : Processor {

    override fun processEvent(event: EventModel) {
        println("message from EMAIL service")
    }

}