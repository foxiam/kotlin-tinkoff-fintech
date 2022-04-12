package homework.lesson7

import homework.lesson7.shop.db.JdbcCatalogRepositoryImpl
import homework.lesson7.shop.model.ItemEnt
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

@JdbcTest
class JdbcRepositoryTest {

    @Autowired
    private lateinit var ds: DataSource

    private lateinit var jdbcCatalogRepositoryImpl: JdbcCatalogRepositoryImpl

    @BeforeEach
    fun setUp() {
        jdbcCatalogRepositoryImpl = JdbcCatalogRepositoryImpl(JdbcTemplate(ds))
    }

    @Test
    fun `get item test`() {
        val item = jdbcCatalogRepositoryImpl.getItem(2)

        assertEquals("pc", item.name)
        assertEquals(120.0, item.price)
    }

    @Test
    fun `get catalog test`() {
        val catalog = jdbcCatalogRepositoryImpl.getCatalog()
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
        assertEquals(3, jdbcCatalogRepositoryImpl.getCatalog().size)
        val item = ItemEnt("TV", 70.0, 4)
        jdbcCatalogRepositoryImpl.addItem(item)

        assertEquals(4, jdbcCatalogRepositoryImpl.getCatalog().size)
        assertEquals(item, jdbcCatalogRepositoryImpl.getItem(4))
    }
}