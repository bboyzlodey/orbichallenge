package data.request

import kotlinx.serialization.Serializable

@Serializable
data class GetStepRecordsRequest(val offset: Int, val count: Int)