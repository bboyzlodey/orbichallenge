package com.skarlat_dev.domain.entities

data class StepRecordEntity(
    val id: String,
    val userId: String,
    val date: String,
    val stepsCount: Int
)
