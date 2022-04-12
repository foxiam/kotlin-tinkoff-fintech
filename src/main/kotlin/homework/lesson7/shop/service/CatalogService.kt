package homework.lesson7.shop.service

import homework.lesson7.shop.db.CatalogRepository
import homework.lesson7.shop.model.*
import homework.lesson7.shop.service.client.CatalogItemClient
import org.springframework.stereotype.Service

@Service
class CatalogService(
    private val catalogRepository: CatalogRepository
    ) {

    fun getItem(id: Int): ItemEnt =
        catalogRepository.getItem(id)

    fun getCatalog(): Set<ItemEnt> =
        catalogRepository.getCatalog()

    fun addItem(item: Item) {
        catalogRepository.addItem(
            ItemEnt(item.name,
                item.price)
        )
    }
}