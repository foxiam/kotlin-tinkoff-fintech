package homework.lesson13.component

import homework.lesson13.model.EventModel
import homework.lesson13.model.EventStatus
import homework.lesson13.model.EventType
import homework.lesson13.service.EmailProcessor
import homework.lesson13.service.EventService
import homework.lesson13.service.PushProcessor
import homework.lesson13.service.SmsProcessor
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class Consumer(
    private val emailProcessor: EmailProcessor,
    private val pushProcessor: PushProcessor,
    private val smsProcessor: SmsProcessor,
    private val eventService: EventService
) {

    @JmsListener(destination = "event.queue")
    fun consumeEvents(event: EventModel) {
        when (event.type) {
            EventType.SMS -> smsProcessor.processEvent(event)
            EventType.EMAIL -> emailProcessor.processEvent(event)
            EventType.PUSH -> pushProcessor.processEvent(event)
        }
        eventService.updateStatus(event, EventStatus.DONE)
    }

}