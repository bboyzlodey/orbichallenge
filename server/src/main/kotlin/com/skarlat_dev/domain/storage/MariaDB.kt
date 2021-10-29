package com.skarlat_dev.domain.storage

import org.jetbrains.exposed.sql.Database

class MariaDB : IDatabase {
    private lateinit var database: Database

    fun connect() {
        database = Database.connect(
            url = "jdbc:mysql://localhost:3306/test", driver = "com.mysql.jdbc.Driver",
            user = "root", password = "your_pwd"
        )
    }
}