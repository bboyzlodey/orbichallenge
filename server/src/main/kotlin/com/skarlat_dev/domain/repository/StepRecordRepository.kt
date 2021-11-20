package com.skarlat_dev.domain.repository

import com.skarlat_dev.domain.entities.StepRecordEntity
import com.skarlat_dev.domain.storage.db.tables.StepRecords
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.replace
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class StepRecordRepository : IStepRecordRepository {
    override suspend fun getStepRecord(profileId: String, date: String): StepRecordEntity {
        return transaction {
            StepRecords.select { (StepRecords.userId eq profileId) and (StepRecords.date eq date) }
                .map {
                    StepRecordEntity(
                        id = it[StepRecords.id],
                        userId = it[StepRecords.userId],
                        date = it[StepRecords.date],
                        stepsCount = it[StepRecords.count]
                    )
                }.first()
        }
    }

    override suspend fun getStepRecords(profileId: String, limit: Int, offset: Int): List<StepRecordEntity> {
        return transaction {
            StepRecords.select { (StepRecords.userId eq profileId) }
                .map {
                    StepRecordEntity(
                        id = it[StepRecords.id],
                        userId = it[StepRecords.userId],
                        date = it[StepRecords.date],
                        stepsCount = it[StepRecords.count]
                    )
                }
        }
    }

    override suspend fun addStepRecord(entity: StepRecordEntity) {
        transaction {
            StepRecords.insert {
                it[userId] = entity.userId
                it[count] = entity.stepsCount
                it[date] = entity.date
            } get StepRecords.id
        }
    }

    override suspend fun addStepRecords(entities: List<StepRecordEntity>) {
        transaction {
            entities.forEach { entity ->
                StepRecords.insert {
                    it[userId] = entity.userId
                    it[count] = entity.stepsCount
                    it[date] = entity.date
                } get StepRecords.id
            }
        }
    }

    override suspend fun updateStepRecords(entity: StepRecordEntity) {
        transaction {
            StepRecords.replace {
                it[userId] = entity.userId
                it[count] = entity.stepsCount
                it[date] = entity.date
            } get StepRecords.id
        }
    }
}