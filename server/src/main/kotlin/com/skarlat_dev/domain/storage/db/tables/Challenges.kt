package com.skarlat_dev.domain.storage.db.tables

import org.jetbrains.exposed.sql.Table

object Challenges : Table("challenges") {
    val id = uuid("id").autoGenerate()
    val name = varchar("name", 30)
    val description = text("description")
    override val primaryKey: PrimaryKey = PrimaryKey(id, name = "PK_challenges_id")
}