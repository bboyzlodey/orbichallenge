package com.skarlat_dev.domain.repository

import com.skarlat_dev.domain.entities.ChallengeEntity
import com.skarlat_dev.domain.storage.db.tables.Challenges
import com.skarlat_dev.utils.MockHelper
import data.models.Challenge
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.stringLiteral
import org.jetbrains.exposed.sql.transactions.transaction

object MockChallengeRepository : IChallengesRepository {
    override suspend fun putChallenge(newChallenge: Challenge) {

    }

    override suspend fun getChallenges(): List<ChallengeEntity> {
        return MockHelper.getChallenges()
    }
}


class ChallengeRepository : IChallengesRepository {
    override suspend fun getChallenges(): List<ChallengeEntity> = transaction {
        Challenges.selectAll().map {
            ChallengeEntity(
                id = it[Challenges.id].toString(),
                title = it[Challenges.name],
                description = it[Challenges.description]
            )
        }
    }

    override suspend fun putChallenge(newChallenge: Challenge) {
        transaction {
            Challenges.insert {
                it.update(name, stringLiteral(newChallenge.title))
                it.update(description, stringLiteral(newChallenge.description))
            }[Challenges.id]
        }
    }
}