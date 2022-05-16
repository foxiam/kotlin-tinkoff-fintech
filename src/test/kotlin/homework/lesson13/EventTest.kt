package homework.lesson13

import homework.lesson13.component.Producer
import homework.lesson13.entity.EventEntity
import homework.lesson13.model.EventStatus
import homework.lesson13.model.EventType
import homework.lesson13.repository.EventRepo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.lang.Thread.sleep

@SpringBootTest
internal class EventTest {

    @Autowired
    private lateinit var producer: Producer

    @Autowired
    private lateinit var eventRepo: EventRepo

    @BeforeEach
    fun setUp() {
        eventRepo.save(
            EventEntity(
                type = EventType.EMAIL,
                body = "Hello from email",
                status = EventStatus.NEW
            )
        )
    }


    @Test
    fun updateEventStatus() {

        producer.produceEvents()
        sleep(200)


        val result = eventRepo.findById(1).get()
        Assertions.assertAll(
            { assertEquals("Hello from email", result.body) },
            { assertEquals(EventStatus.DONE, result.status) },
            { assertEquals(EventType.EMAIL, result.type) }
        )
    }
}
