package com.example.demo.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/people")
@CrossOrigin(origins = ["*"])
class PeopleController {

    companion object {
        val people: List<Person> = listOf(
            Person(1, "Roneldson", 45, 1.7),
            Person(2, "Robson", 30, 1.6),
            Person(3, "Robertao", 60, 1.7)
        )
    }

    @GetMapping
    fun getPeople() : List<Person> {
        return people
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id : Int) : Person? {
        return people.first { it.id == id }
    }

}

class Person(val id: Int, val name: String, val age: Int, val height: Double) {

}
