package homework.lesson9.shop.entity

import javax.persistence.*

@Entity
@Table(name = "items")
data class ItemEntity(
    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Double,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = null
    )