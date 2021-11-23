package client.business.converter

import client.business.model.StepRecordBusiness
import data.models.StepRecord

class StepRecordConverter {
    fun convert(networkModel: StepRecord): StepRecordBusiness = StepRecordBusiness(
        id = networkModel.id,
        stepsCount = networkModel.stepsCount,
        date = networkModel.date
    )
}