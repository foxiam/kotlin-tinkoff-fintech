package homework.lesson9.shop.controller

import homework.lesson9.shop.entity.ItemEntity
import homework.lesson9.shop.service.CatalogService
import homework.lesson9.shop.model.Item
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/catalog")
class CatalogController(private val catalogService: CatalogService) {

    @GetMapping
    fun getCatalog(): Set<ItemEntity> =
        catalogService.getCatalog()

    @GetMapping("/{id}")
    fun getItem(@PathVariable id: Int): ItemEntity =
        catalogService.getItem(id)

    @PostMapping
    fun addItem(item: Item) {
        catalogService.addItem(item)
    }
}