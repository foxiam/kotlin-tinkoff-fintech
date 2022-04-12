package homework.lesson7.shop.controller

import homework.lesson7.shop.model.*
import homework.lesson7.shop.service.CatalogService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/catalog")
class CatalogController(private val catalogService: CatalogService) {

    @GetMapping("/")
    fun getCatalog(): Set<ItemEnt> =
        catalogService.getCatalog()

    @GetMapping("/{id}")
    fun getItem(@PathVariable id: Int): ItemEnt =
        catalogService.getItem(id)

    @PostMapping("/add")
    fun addItem(@RequestBody item: Item) {
        catalogService.addItem(item)
    }
}