package homework.lesson9.shop.db

import homework.lesson9.shop.entity.ItemEntity
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Primary
@Service
class JpaCatalogRepositoryImpl(private val repository: JpaCatalogRepo) : CatalogRepository {

    override fun getItem(id: Int): ItemEntity {
        return repository.findById(id).get()
    }

    override fun getCatalog(): Set<ItemEntity> {
        return repository.findAll().toSet()
    }

    override fun addItem(item: ItemEntity) {
        repository.save(item)
    }

}