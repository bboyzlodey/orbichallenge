package com.skarlat_dev.domain.storage.db.tables

import org.jetbrains.exposed.sql.Table

object Antropometrics : Table("antropometrics") {
    val id = varchar("id", 25)
    val sex = varchar("sex", 10)
    val weight = float("weight")
    val height = integer("height")
    override val primaryKey: PrimaryKey = PrimaryKey(id, name = "PK_antropometric_id")
}