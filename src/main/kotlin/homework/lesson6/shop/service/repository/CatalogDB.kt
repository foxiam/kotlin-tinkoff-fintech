package homework.lesson6.shop.service.repository

import homework.lesson6.shop.model.Item
import org.springframework.stereotype.Repository

@Repository
class CatalogDB {

    private val items = mutableMapOf<String, Item>()

    fun get(): Set<Item> = items.map{ it.value }.toSet()

    fun addItem(item: Item) {
        items[item.name] = item
    }

    fun getItem(name: String) : Item? =
        items[name]

    fun getFilteredItemByPrice(price: Double): Set<Item> = items.filter { it.value.price <= price }.
        values.ifEmpty { throw NoSuchElementException( "Отсутствует товар дешевле $price" ) }.toSet()
}