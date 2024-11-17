package org.example.Repo

import org.example.dataClasses.PersonDto
import org.example.models.Person
import org.jetbrains.exposed.sql.batchInsert
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.json.contains
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.upsert

class PersonRepo(
    private val repo: Person = Person
) {

    fun deleteAll() = transaction {
        Person.deleteAll()
    }

    fun getCount() = transaction {
        Person.selectAll().count()
    }

    fun insert(name: String, age: Int): Int = transaction {
        return@transaction Person.insertAndGetId {
            it[Person.name] = name
            it[Person.age] = 20
        }.value
    }

    fun getAll() = transaction {
        Person.selectAll()
            .map { PersonDto(it[Person.id].value, it[Person.name], it[Person.age]) }
    }

    fun getDictionary(name: String?) = transaction {
        Person.select(Person.id, Person.name)
            .where { Person.name like (name ?: "") }
            .map { it[Person.id].value to it[Person.name] }
    }

    fun insertBatch(personNames: List<PersonDto>) = transaction {
        Person.batchInsert(personNames) { p ->
            this[Person.name] = p.name
            this[Person.age] = p.age
        }
    }

    fun insertOrUpdate(p: PersonDto) = transaction {
        Person.upsert {
            it[Person.name] = p.name
            it[Person.age] = p.age
            it[Person.id] = p.id
        }
    }
}