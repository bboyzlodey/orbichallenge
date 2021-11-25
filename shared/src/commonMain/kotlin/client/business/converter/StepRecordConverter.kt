package client.business.converter

import client.business.model.StepRecordBusiness
import data.models.StepRecord

class StepRecordConverter(private val dateTimeConverter: DateTimeConverter) {
    fun convert(networkModel: StepRecord): StepRecordBusiness = StepRecordBusiness(
        id = networkModel.id,
        stepsCount = networkModel.stepsCount,
        date = dateTimeConverter.fromServer(networkModel.date)
    )
}