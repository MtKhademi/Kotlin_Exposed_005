package org.example

import org.example.Repo.PersonRepo
import org.example.dataClasses.PersonDto

fun main() {

    DatabaseConfig.initDatabase()


    val personRepo = PersonRepo()
    personRepo.deleteAll()

//    val countPerson = personRepo.getCount()
//    println("Count persons : $countPerson")

//    var personId = personRepo.insert("new name", 12)
//    println("Person ID : $personId")
//
//    var persons = personRepo.getAll()
//    println("Persons\n : $persons")
//
//    println("Person Dic : \n ${personRepo.getDictionary("")}")

    personRepo.insertBatch(arrayOf(PersonDto(1, "Khiar", 1), PersonDto(2, "Kado", 2)).toList())
    personRepo.insertOrUpdate(PersonDto(13, "Khiar Jadid", 13))
    println("Persons\n : ${personRepo.getAll()}")



    personRepo.insertOrUpdate(PersonDto(13, "Khiar Jadid - KIR TOSH", 3))
    println("Persons\n : ${personRepo.getAll()}")


}