package homework.lesson6.shop.controller

import homework.lesson6.shop.model.Item
import homework.lesson6.shop.service.CatalogService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/catalog")
class CatalogController(private val catalogService: CatalogService) {

    @GetMapping("/")
    fun getCatalog(): Set<Item> =
        catalogService.getCatalog()

    @GetMapping("/{name}")
    fun getItem(@PathVariable name: String): Item =
        catalogService.getItem(name)

    @GetMapping("/filtered-by-price")
    fun getFilteredItemByPrice(@RequestParam price: Double) =
        catalogService.getFilteredItemByPrice(price)

    @PostMapping("/add")
    fun addItem(@RequestBody nameItem: String): Item =
        catalogService.addItem(nameItem)
}