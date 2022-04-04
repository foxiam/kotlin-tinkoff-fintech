package homework.lesson6

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ninjasquad.springmockk.MockkBean
import com.ninjasquad.springmockk.SpykBean
import homework.lesson6.shop.model.Item
import homework.lesson6.shop.service.client.CatalogItemClient
import homework.lesson6.shop.service.repository.CatalogDB
import io.kotest.core.extensions.Extension
import io.kotest.core.spec.style.FeatureSpec
import io.kotest.core.test.TestCase
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.mockk.every
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActionsDsl
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import kotlin.text.Charsets.UTF_8

@SpringBootTest
@AutoConfigureMockMvc
class CatalogServiceTest(private val mockMvc: MockMvc, private val objectMapper: ObjectMapper) : FeatureSpec() {

    @MockkBean
    private lateinit var catalogItemClient: CatalogItemClient

    @SpykBean
    private lateinit var catalogDB: CatalogDB

    override fun extensions(): List<Extension> = listOf(SpringExtension)

    override fun beforeEach(testCase: TestCase) {
        initItems()
        every { catalogItemClient.getCatalog() } returns items
        every { catalogItemClient.getItem(any()) } answers { items.find { it.name == firstArg() } }
        every { catalogItemClient.getItem(tv.name) } returns tv
        every { catalogItemClient.getItem("missing item") } returns null
    }

    init {
        feature("add item") {
            scenario("success") {
                getStatusOfGetItem(tv.name) shouldBe HttpStatus.BAD_REQUEST.value()
                val item = addItem(tv.name)
                item shouldBe tv
                getStatusOfGetItem(tv.name) shouldBe HttpStatus.OK.value()
            }
            scenario("failure - unknown item") {
                getStatusOfAddItem("missing item") shouldBe HttpStatus.INTERNAL_SERVER_ERROR.value()
            }
        }

        feature("get item") {
            scenario("success") {
                val item = getItem(notebook.name)
                item shouldBe notebook
            }
            scenario("failure - unknown item") {
                getStatusCodeOfGetItem("missing item") shouldBe HttpStatus.BAD_REQUEST.value()
            }
        }

        feature("get item") {
            scenario("success") {
                val item = getItem(notebook.name)
                item shouldBe notebook
            }
            scenario("failure - unknown item") {
                getStatusCodeOfGetItem("missing item") shouldBe HttpStatus.BAD_REQUEST.value()
            }
        }

        feature("filtered item by price") {
            scenario("success") {
                val items = getItemsFilteredByPrice(80.0)
                items shouldBe setOf(tv, smartphone)
            }
        }
    }

    private fun getStatusOfGetItem(name: String) =
        mockMvc.get("/catalog/{name}", name).andReturn().response.status

    private fun addItem(name: String): Item =
        mockMvc.post("/catalog/add") { contentType = MediaType.TEXT_PLAIN; content = name }.readResponse()

    private fun getStatusOfAddItem(name: String) =
        mockMvc.post("/catalog/add") { contentType = MediaType.TEXT_PLAIN; content = name }
        .andReturn().response.status

    private fun getItem(name: String): Item =
        mockMvc.get("/catalog/{name}", name).readResponse()

    private fun getStatusCodeOfGetItem(name: String): Int =
        mockMvc.get("/catalog/{name}", name).andReturn().response.status

    private fun getItemsFilteredByPrice(price: Double): Set<Item> =
        mockMvc.get("/catalog/filtered-by-price?price={price}", price).readResponse()

    private inline fun <reified T> ResultActionsDsl.readResponse(expectedStatus: HttpStatus = HttpStatus.OK): T = this
        .andExpect { status { isEqualTo(expectedStatus.value()) } }
        .andReturn().response.getContentAsString(UTF_8)
        .let { if (T::class == String::class) it as T else objectMapper.readValue(it) }

    private val items = setOf(
        notebook,
        pc,
        smartphone
    )

    private fun initItems() {
        catalogDB.addItem(notebook)
        catalogDB.addItem(pc)
        catalogDB.addItem(smartphone)
    }

    private companion object {
        private val tv = Item("TV", 50.0)
        private val notebook = Item("Notebook", 100.0)
        private val pc = Item("PC", 130.0)
        private val smartphone = Item("Smartphone", 80.0)
    }
}