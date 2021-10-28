package com.skarlat_dev.domain.converters

import com.skarlat_dev.domain.entities.AntropometricInfoEntity
import com.skarlat_dev.domain.entities.StepRecordEntity
import data.models.AntropometricInfo
import data.models.Sex
import data.models.StepRecord
import java.util.*

class StepRecordConverter {

    fun toNetworkModel(entity: StepRecordEntity): StepRecord =
        StepRecord(id = entity.id, date = entity.date, stepsCount = entity.stepsCount)

    fun toEntity(networkModel: StepRecord) : StepRecordEntity =
        StepRecordEntity(id = UUID.randomUUID().toString(), userId = "", date = networkModel.date, stepsCount = networkModel.stepsCount)
}