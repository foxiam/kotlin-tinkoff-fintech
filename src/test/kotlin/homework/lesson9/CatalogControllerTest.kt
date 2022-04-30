package homework.lesson9

import com.ninjasquad.springmockk.MockkBean
import homework.lesson9.shop.db.CatalogRepository
import homework.lesson9.shop.entity.ItemEntity
import homework.lesson9.shop.service.client.CatalogClient
import io.mockk.coEvery
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class CatalogControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockkBean
    private lateinit var catalogClient: CatalogClient

    @MockkBean
    lateinit var catalogRepository: CatalogRepository

    private companion object {
        private val resultItem = ItemEntity("notebook", 100.0)
    }

    @Test
    fun `test get item by id`() {
        every { catalogRepository.getItem(1) } returns resultItem
        mockMvc.perform(
            get
                ("/catalog/1")
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("notebook"))
            .andExpect(jsonPath("$.price").value(100.0))
    }

    @Test
    fun `test add item to repository`() {

        coEvery { catalogClient.addItem(any()) } returns resultItem

        mockMvc.perform(
            post("/catalog")
                .param("name", "notebook")
                .param("price", "100.0")
        ).andExpect(status().isOk)
    }
}