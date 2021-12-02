package com.skarlat_dev.domain.repository

import com.skarlat_dev.domain.entities.ProfileEntity
import com.skarlat_dev.domain.storage.db.tables.Users
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class ProfileRepository : IProfileRepository {
    override suspend fun getProfile(uuid: String): ProfileEntity? = transaction {
        Users.select {
            Users.id eq UUID.fromString(uuid)
        }.firstOrNull()?.run {
            ProfileEntity(
                id = this[Users.id].toString(),
                firstName = this[Users.firstName],
                secondName = this[Users.secondName],
                birthday = this[Users.birthday],
                email = this[Users.email]
            )
        }
    }

    override fun putProfile(profile: ProfileEntity) {
        transaction {
            Users.insert {
                it[Users.id] = UUID.fromString(profile.id)
                it[Users.email] = profile.email
                it[Users.birthday] = profile.birthday
                it[Users.firstName] = profile.firstName
                it[Users.secondName] = profile.secondName
            }
        }
    }
}