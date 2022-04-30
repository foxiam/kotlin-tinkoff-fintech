package homework.lesson9.shop.db

import homework.lesson9.shop.entity.ItemEntity
import org.springframework.stereotype.Repository

@Repository
interface  CatalogRepository {

    fun getItem(id: Int): ItemEntity

    fun getCatalog(): Set<ItemEntity>

    fun addItem(itemEnt: ItemEntity)

}