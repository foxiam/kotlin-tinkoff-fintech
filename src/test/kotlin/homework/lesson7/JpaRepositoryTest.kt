package homework.lesson7

import homework.lesson7.shop.db.JpaCatalogRepo
import homework.lesson7.shop.db.JpaCatalogRepositoryImpl
import homework.lesson7.shop.model.ItemEnt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.test.annotation.DirtiesContext

@DataJpaTest
class JpaRepositoryTest {
    @Autowired
    private lateinit var jpaCatalogRepo: JpaCatalogRepo

    private lateinit var jpaCatalogRepositoryImpl: JpaCatalogRepositoryImpl

    @BeforeEach
    fun setUp() {
        jpaCatalogRepositoryImpl = JpaCatalogRepositoryImpl(jpaCatalogRepo)
        jpaCatalogRepositoryImpl.addItem(ItemEnt("notebook", 100.0, 1))
        jpaCatalogRepositoryImpl.addItem(ItemEnt("pc", 120.0, 2))
        jpaCatalogRepositoryImpl.addItem(ItemEnt("smartphone", 80.0, 3))
    }

    @Test
    fun `get item test`() {
        val item = jpaCatalogRepositoryImpl.getItem(2)

        assertEquals("pc", item.name)
        assertEquals(120.0, item.price)
    }

    @Test
    fun `get catalog test`() {
        val catalog = jpaCatalogRepositoryImpl.getCatalog()
        val catalog2 = setOf(
            ItemEnt("notebook", 100.0, 1),
            ItemEnt("pc", 120.0, 2),
            ItemEnt("smartphone", 80.0, 3)
        )

        assertEquals(3, catalog.size)
        assertEquals(catalog2, catalog)
    }

    @Test
    fun `add item test`() {
        assertEquals(3, jpaCatalogRepositoryImpl.getCatalog().size)
        val item = ItemEnt("TV", 70.0, 4)
        jpaCatalogRepositoryImpl.addItem(item)

        assertEquals(4, jpaCatalogRepositoryImpl.getCatalog().size)
        assertEquals(item, jpaCatalogRepositoryImpl.getItem(4))
    }
}