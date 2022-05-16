package homework.lesson13.repository

import homework.lesson13.entity.EventEntity
import homework.lesson13.model.EventStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface EventRepo : JpaRepository<EventEntity, Long> {

    fun findAllByStatus(status: EventStatus): List<EventEntity>

    @Modifying
    @Query("UPDATE EventEntity e SET e.status = ?1 WHERE e.id = ?2")
    fun updateStatus(status: EventStatus, id: Long)

}