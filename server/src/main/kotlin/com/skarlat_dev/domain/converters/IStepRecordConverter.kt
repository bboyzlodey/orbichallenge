package com.skarlat_dev.domain.converters

import com.skarlat_dev.domain.entities.StepRecordEntity
import data.models.StepRecord
import io.netty.util.Mapping

interface IStepRecordConverter {
    val fromEntityToNetwork: Mapping<StepRecordEntity, StepRecord>
    val fromNetworkToEntity: Mapping<StepRecord, StepRecordEntity>
}