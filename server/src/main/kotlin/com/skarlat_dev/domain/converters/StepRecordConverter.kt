package com.skarlat_dev.domain.converters

import com.skarlat_dev.domain.entities.StepRecordEntity
import data.models.StepRecord
import io.netty.util.Mapping
import java.util.*

class StepRecordConverter : IStepRecordConverter {

    private fun toNetworkModel(entity: StepRecordEntity): StepRecord =
        StepRecord(id = entity.id, date = entity.date, stepsCount = entity.stepsCount)

    private fun toEntity(networkModel: StepRecord): StepRecordEntity =
        StepRecordEntity(
            id = UUID.randomUUID().toString(),
            userId = "",
            date = networkModel.date,
            stepsCount = networkModel.stepsCount
        )

    override val fromEntityToNetwork: Mapping<StepRecordEntity, StepRecord> =
        Mapping { entity -> toNetworkModel(entity) }
    override val fromNetworkToEntity: Mapping<StepRecord, StepRecordEntity> =
        Mapping { network -> toEntity(network) }
}