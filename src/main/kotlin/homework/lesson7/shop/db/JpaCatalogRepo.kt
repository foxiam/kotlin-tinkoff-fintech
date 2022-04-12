package homework.lesson7.shop.db

import homework.lesson7.shop.model.ItemEnt
import org.springframework.data.jpa.repository.JpaRepository

interface JpaCatalogRepo: JpaRepository<ItemEnt, Int>