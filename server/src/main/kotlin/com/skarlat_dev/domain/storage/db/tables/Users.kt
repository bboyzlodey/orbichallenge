package com.skarlat_dev.domain.storage.db.tables

import org.jetbrains.exposed.sql.Table
import utils.Const

object Users : Table("users") {
    val id = uuid("id")
    val firstName = varchar("firstName", 30)
    val secondName = varchar("secondName", 30)
    val email = varchar("email", 30)
    val birthday = this.varchar("birthday", Const.DATE_SERVER_FORMAT.length)
    override val primaryKey: PrimaryKey = PrimaryKey(id, name = "PK_user_id")
}