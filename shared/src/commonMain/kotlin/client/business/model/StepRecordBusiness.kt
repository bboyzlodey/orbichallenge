package client.business.model

import kotlinx.datetime.LocalDateTime

data class StepRecordBusiness(val id: String, val stepsCount: Int, val date: LocalDateTime)
