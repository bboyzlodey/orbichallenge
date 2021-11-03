package com.skarlat_dev.domain.repository

import com.skarlat_dev.domain.storage.db.tables.Challenges
import com.skarlat_dev.utils.MockHelper
import data.models.Challenge
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object MockChallengeRepository : IChallengesRepository {
    override suspend fun getChallenges(): List<Challenge> {
        return MockHelper.getChallenges()
    }
}


class ChallengeRepository : IChallengesRepository {
    override suspend fun getChallenges(): List<Challenge> = transaction {
        Challenges.selectAll().map {
            Challenge(
                id = it[Challenges.id],
                title = it[Challenges.name],
                description = it[Challenges.description]
            )
        }
    }
}