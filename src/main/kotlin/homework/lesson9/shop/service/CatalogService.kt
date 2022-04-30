package homework.lesson9.shop.service

import homework.lesson9.shop.db.CatalogRepository
import homework.lesson9.shop.entity.ItemEntity
import homework.lesson9.shop.model.Item
import homework.lesson9.shop.service.client.CatalogClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class CatalogService(
    private val catalogRepository: CatalogRepository,
    private val catalogClient: CatalogClient
    ) {

    fun getItem(id: Int): ItemEntity =
        catalogRepository.getItem(id)

    fun getCatalog(): Set<ItemEntity> =
        catalogRepository.getCatalog()

    fun addItem(item: Item) {
        CoroutineScope(Dispatchers.Default).launch {
            val responseItem = catalogClient.addItem(item)
            withContext(Dispatchers.IO) {
                catalogRepository.addItem(responseItem)
            }
        }
    }
}