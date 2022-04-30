package homework.lesson9.shop.db

import homework.lesson9.shop.entity.ItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaCatalogRepo: JpaRepository<ItemEntity, Int>