package com.example.demo.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity(name = "people")
class Person(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int,
    @Column(name = "name")
    val name: String,
    @Column(name = "age")
    val age: Int,
    @Column(name = "height")
    val height: Double
) {
}