package org.example.Tables

import org.jetbrains.exposed.sql.Table

object Cities : Table("Cities") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 50)
}