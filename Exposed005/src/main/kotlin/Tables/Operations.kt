package org.example.Tables

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class Operations {

    companion object {
        //INSERT OPERATION
        fun citiesInsert(name: String) = transaction {
            Cities.insert {
                it[Cities.name] = name
            }
        }


        fun starWarsFilesInsertAndGetId(name:String)=transaction{
            StarWarsFilms.update({ StarWarsFilms.name eq name }){
                it[StarWarsFilms.name] = " [NEW NAME] ${StarWarsFilms.name} "
            }
        }
    }

}