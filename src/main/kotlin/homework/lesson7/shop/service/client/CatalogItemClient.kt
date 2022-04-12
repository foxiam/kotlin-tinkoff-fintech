package homework.lesson7.shop.service.client

import homework.lesson7.shop.model.Item
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.NotFound
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange
import org.springframework.web.client.getForObject


@Service
class CatalogItemClient(
    private val restTemplate: RestTemplate,
    @Value("\${catalog.address}") private val catalogAddress: String
    ) {

    fun getCatalog() : Set<Item> =
        restTemplate.exchange<Set<Item>>("$catalogAddress$GET_CATALOG", HttpMethod.GET).body.orEmpty()

    fun getItem(id: Int): Item? = try {
        restTemplate.getForObject<Item>("$catalogAddress$GET_ITEM_BY_NAME", id)
    } catch (e: NotFound) {
        null
    }
}

private const val GET_CATALOG = "/catalog"
private const val GET_ITEM_BY_NAME = "/catalog?name={name}"