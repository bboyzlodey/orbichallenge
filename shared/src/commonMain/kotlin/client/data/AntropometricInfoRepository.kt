package client.data

import client.core.Dispatchers
import data.models.AntropometricInfo
import data.network.ServerApiClient
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class AntropometricInfoRepository(private val serverApiClient: ServerApiClient) {
    suspend fun getAntropometricInfo(): AntropometricInfo =
        serverApiClient.getAntropometricInfo()

    suspend fun getAntropometricInfoFlow() =
        flowOf(serverApiClient.getAntropometricInfo()).flowOn(Dispatchers.IO)

    suspend fun setAntropometricInfo(body: AntropometricInfo) =
        serverApiClient.setAntropometricInfo(body)

    suspend fun setAntropometricInfoFlow(body: AntropometricInfo) =
        flowOf(serverApiClient.setAntropometricInfo(body)).flowOn(Dispatchers.IO)
}