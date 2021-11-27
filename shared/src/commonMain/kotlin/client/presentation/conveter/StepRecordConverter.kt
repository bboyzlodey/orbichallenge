package client.presentation.conveter

import client.business.model.StepRecordBusiness
import client.presentation.model.StepRecordUI
import client.presentation.utils.DateTimeFormatter

class StepRecordConverter {

    private val dateTimeFormatter = DateTimeFormatter()

    fun toUIModel(business: StepRecordBusiness): StepRecordUI =
        StepRecordUI(
            id = business.id,
            date = dateTimeFormatter.formatDDMM(business.date),
            stepsCount = business.stepsCount
        )
}