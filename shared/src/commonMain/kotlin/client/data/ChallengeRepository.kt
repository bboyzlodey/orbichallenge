package client.data

import data.models.Challenge
import data.network.ServerApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ChallengeRepository(private val serverApiClient: ServerApiClient) {

    suspend fun getChallenges() : List<Challenge> {
        return serverApiClient.getChallenges()
    }

    fun getChallengesFlow() : Flow<List<Challenge>> {
        return flow { emit(getChallenges()) }.flowOn(client.core.Dispatchers.IO)
    }
}