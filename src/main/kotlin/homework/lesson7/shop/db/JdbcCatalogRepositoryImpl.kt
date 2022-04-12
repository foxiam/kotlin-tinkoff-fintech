package homework.lesson7.shop.db

import homework.lesson7.shop.model.*
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.stereotype.Service

//@Primary
@Service
class JdbcCatalogRepositoryImpl(val jdbcTemplate: JdbcTemplate) : CatalogRepository {

    override fun getItem(id: Int): ItemEnt {
        val statementCreator = PreparedStatementCreator { con ->
            val ps = con.prepareStatement("SELECT * FROM items WHERE id = ?")
            ps.setInt(1, id)
            ps
        }
        return jdbcTemplate.query(statementCreator) {rs, _ ->
            ItemEnt(
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getInt("id")
            )
        }[0]
    }

    override fun getCatalog(): Set<ItemEnt> {
        return jdbcTemplate.query("select * from items") { rs, _ ->
            ItemEnt(
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getInt("id")
            )
        }.toSet()
    }

    override fun addItem(item: ItemEnt) {
        val statementCreator = PreparedStatementCreator { con ->
            val ps = con.prepareStatement("INSERT INTO items (name, price) VALUES (?, ?)")
            ps.setString(1, item.name)
            ps.setDouble(2, item.price)
            ps
        }
        jdbcTemplate.update(statementCreator)
    }

}