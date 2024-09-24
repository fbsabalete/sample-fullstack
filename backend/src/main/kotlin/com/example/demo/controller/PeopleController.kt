package com.example.demo.controller

import com.example.demo.PersonRepository
import com.example.demo.exception.NotFoundException
import com.example.demo.model.Person
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/people")
@CrossOrigin(origins = ["*"])
class PeopleController(
    private val personRepository: PersonRepository
) {

    @GetMapping
    fun getPeople() : List<Person> {
        return personRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id : Int) : Person {
        return personRepository.findByIdOrNull(id) ?: throw NotFoundException("Person not found");
    }

}
