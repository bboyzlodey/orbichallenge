package com.skarlat_dev.domain.repository

import com.skarlat_dev.domain.entities.StepRecordEntity

interface IStepRecordRepository {
    suspend fun getStepRecord(profileId: String, date: String): StepRecordEntity
    suspend fun getStepRecords(profileId: String, limit: Int, offset: Int): List<StepRecordEntity>
    suspend fun addStepRecord(entity: StepRecordEntity)
    suspend fun addStepRecords(entities: List<StepRecordEntity>)
    suspend fun updateStepRecords(entity: StepRecordEntity)
}