 package client.data

import client.core.Dispatchers
import data.models.StepRecord
import data.network.ServerApiClient
import data.request.GetStepRecordsRequest
import data.response.GetStepRecordsResponse
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class StepRecordRepository(private val serverApiClient: ServerApiClient) {
    suspend fun getStepRecords(request: GetStepRecordsRequest): GetStepRecordsResponse =
        serverApiClient.getStepRecords()

    suspend fun getStepRecordsFlow(request: GetStepRecordsRequest) =
        flow { emit(getStepRecords(request)) }.flowOn(Dispatchers.IO)

    suspend fun sendStepRecords(body: List<StepRecord>) =
        serverApiClient.sendStepRecords(body)

    suspend fun sendStepRecordsFlow(body: List<StepRecord>) =
        flow { emit(sendStepRecords(body)) }.flowOn(Dispatchers.IO)
}