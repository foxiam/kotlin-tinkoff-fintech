package homework.lesson7.shop.db

import homework.lesson7.shop.model.*
import org.springframework.stereotype.Repository

@Repository
interface  CatalogRepository {

    fun getItem(id: Int): ItemEnt

    fun getCatalog(): Set<ItemEnt>

    fun addItem(itemEnt: ItemEnt)

}