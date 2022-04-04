package homework.lesson6.shop.service

import homework.lesson6.shop.model.Item
import homework.lesson6.shop.service.client.CatalogItemClient
import homework.lesson6.shop.service.repository.CatalogDB
import org.springframework.stereotype.Service

@Service
class CatalogService(
    private val catalogItemClient: CatalogItemClient,
    private val catalogDB: CatalogDB
    ) {

    fun getCatalog(): Set<Item> =
        catalogDB.get()

    fun getItem(name: String): Item {
        val item = catalogDB.getItem(name)
        return requireNotNull(item) { "Товар $name отсутствует в БД" }
    }

    fun addItem(itemName: String): Item {
        val item = catalogItemClient.getItem(itemName)
        checkNotNull(item) { "Сервису не удалось найти товар: \"$itemName\""  }
        catalogDB.addItem(item)
        return item
    }

    fun getFilteredItemByPrice(price: Double) = catalogDB.getFilteredItemByPrice(price)
}