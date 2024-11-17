package org.example

import org.example.models.Person
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseConfig {
    companion object{
        fun initDatabase(){
            Database.connect(
                url = "jdbc:postgresql://localhost:5432/test",
                driver = "org.postgresql.Driver",
                user = "postgres",
                password = "123456"
            )
            println("success init database")

            transaction{
                SchemaUtils.create(Person)
            }

            println("success create schemas")
        }
    }
}