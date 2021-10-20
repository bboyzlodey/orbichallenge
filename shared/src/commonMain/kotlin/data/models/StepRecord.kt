package data.models

import kotlinx.serialization.Serializable

@Serializable
data class StepRecord(val id: String, val date: String, val stepsCount: Int)
