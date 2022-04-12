package homework.lesson7.shop.db

import homework.lesson7.shop.model.*
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Primary
@Service
class JpaCatalogRepositoryImpl(private val repository: JpaCatalogRepo) : CatalogRepository {

    override fun getItem(id: Int): ItemEnt {
        return repository.findById(id).get()
    }

    override fun getCatalog(): Set<ItemEnt> {
        return repository.findAll().toSet()
    }

    override fun addItem(item: ItemEnt) {
        repository.save(item)
    }

}