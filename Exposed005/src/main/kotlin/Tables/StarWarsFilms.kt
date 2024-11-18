package org.example.Tables

import org.jetbrains.exposed.dao.id.IntIdTable

object StarWarsFilms : IntIdTable(name = "star_wars_films") {
    val sequelId = integer(name = "sequel_Id").uniqueIndex()
    val name = varchar(name = "name", length = 50)
    val director = varchar(name = "director", length = 50)

}