package data.response

import data.models.StepRecord
import kotlinx.serialization.Serializable

@Serializable
data class GetStepRecordsResponse(val records: List<StepRecord>, val count: Int)
