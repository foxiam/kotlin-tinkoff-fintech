package homework.lesson13.model

import java.io.Serializable

data class EventModel(
    val id: Long,
    val type: EventType,
    val body: String,
    var status: EventStatus
) : Serializable