package homework.lesson9.shop.service.client

import homework.lesson9.shop.entity.ItemEntity
import homework.lesson9.shop.model.Item
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import reactor.core.publisher.Mono

@Component
class CatalogClient(private val webClient: WebClient) {

    suspend fun addItem(item: Item): ItemEntity = webClient.post()
        .uri("/catalog")
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(Mono.just(item), Item::class.java)
        .retrieve()
        .awaitBody()
}