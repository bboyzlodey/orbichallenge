package com.skarlat_dev.domain.storage.db

import com.skarlat_dev.domain.storage.IDatabase
import com.skarlat_dev.domain.storage.db.tables.Antropometrics
import com.skarlat_dev.domain.storage.db.tables.Challenges
import com.skarlat_dev.domain.storage.db.tables.StepRecords
import com.skarlat_dev.domain.storage.db.tables.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class MariaDB : IDatabase {
    private lateinit var database: Database

    fun connect() {
        database = Database.connect(
            url = "jdbc:mysql://localhost:3306/test", driver = "com.mysql.cj.jdbc.Driver",
            user = "denis", password = "denis90_1I",
            setupConnection = { connection ->
                println("Connection to db is ${connection.isValid(3)}")
            }
        )
        transaction {
            SchemaUtils.create(Antropometrics, Challenges, StepRecords, Users)
        }
    }
}