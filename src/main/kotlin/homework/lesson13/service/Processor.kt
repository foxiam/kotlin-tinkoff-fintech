package homework.lesson13.service

import homework.lesson13.model.EventModel

interface Processor {

    fun processEvent(event: EventModel)

}