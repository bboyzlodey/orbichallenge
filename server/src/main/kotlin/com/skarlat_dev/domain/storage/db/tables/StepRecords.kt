package com.skarlat_dev.domain.storage.db.tables

import org.jetbrains.exposed.sql.Table
import utils.Const

object StepRecords : Table("step_records") {
    val id = varchar("id", 25)
    val userId = varchar("userId", 25)
    val count = integer("count")
    val date = varchar("date", Const.DATE_SERVER_FORMAT.length)
    override val primaryKey: PrimaryKey = PrimaryKey(id, name = "PK_step_record_id")
}