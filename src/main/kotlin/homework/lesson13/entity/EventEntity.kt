package homework.lesson13.entity

import homework.lesson13.model.EventModel
import homework.lesson13.model.EventStatus
import homework.lesson13.model.EventType
import javax.persistence.*

@Table(name = "events")
@Entity
class EventEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "e_type")
    val type: EventType,

    @Column(name = "body")
    val body: String,

    @Column(name = "status")
    var status: EventStatus
) {

    fun toModel() =
        EventModel(
            id!!,
            type,
            body,
            status
        )

}