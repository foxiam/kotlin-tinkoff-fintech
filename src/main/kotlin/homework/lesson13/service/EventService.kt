package homework.lesson13.service

import homework.lesson13.model.EventModel
import homework.lesson13.model.EventStatus
import homework.lesson13.repository.EventRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EventService(
    @Autowired
    private val eventRepo: EventRepo
) {

    fun getNewEvents() =
        eventRepo.findAllByStatus(EventStatus.NEW).map { it.toModel() }

    @Transactional
    fun updateStatus(event: EventModel, status: EventStatus) {
        eventRepo.updateStatus(status, event.id)
    }

}