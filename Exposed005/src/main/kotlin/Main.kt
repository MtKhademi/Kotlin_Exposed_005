package org.example

import org.example.Repo.PersonRepo
import org.example.Tables.Cities
import org.example.Tables.Operations
import org.example.dataClasses.PersonDto

fun main() {

    DatabaseConfig.initDatabase()

    Operations.citiesInsert(name = "Iran")

    println(Cities.name)


}