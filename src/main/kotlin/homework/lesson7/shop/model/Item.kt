package homework.lesson7.shop.model

import javax.persistence.*

data class Item(
    val name: String,
    val price: Double
)

@Entity
@Table(name = "items")
data class ItemEnt(
    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Double,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    var id: Int? = null
    )