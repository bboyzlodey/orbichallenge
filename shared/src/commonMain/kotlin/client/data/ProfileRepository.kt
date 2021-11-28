package client.data

import client.core.Dispatchers
import data.models.Profile
import data.network.ServerApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProfileRepository(private val serverApiClient: ServerApiClient) {
    suspend fun getProfile(): Profile =
        serverApiClient.getProfile()
    suspend fun getProfileFlow(): Flow<Profile> =
        flow { emit(getProfile()) }.flowOn(Dispatchers.IO)
}