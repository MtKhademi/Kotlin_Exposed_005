package org.example.models

import org.jetbrains.exposed.dao.id.IntIdTable

object Person : IntIdTable() {
    val name = varchar("name", 255)
    val age = integer("age")

}