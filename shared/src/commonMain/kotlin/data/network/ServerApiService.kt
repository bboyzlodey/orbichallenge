package data.network

import data.models.AntropometricInfo
import data.models.Challenge
import data.models.Profile
import data.models.StepRecord
import data.response.GetStepRecordsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ServerApiService(private val serverApi: ServerApi) {

    fun getStepRecords(): Flow<GetStepRecordsResponse> =
        flow { emit(serverApi.getStepRecords()) }

    fun getChallenges(): Flow<List<Challenge>> =
        flow { emit(serverApi.getChallenges()) }

    fun getProfile(): Flow<Profile> =
        flow { emit(serverApi.getProfile()) }

    fun getAntropometricInfo(): Flow<AntropometricInfo> =
        flow { emit(serverApi.getAntropometricInfo()) }

    fun sendStepRecord(body: StepRecord): Flow<Any?> =
        flow { emit(serverApi.sendStepRecord(body)) }

    fun sendStepRecords(body: List<StepRecord>): Flow<Any?> =
        flow { emit(serverApi.sendStepRecords(body)) }

    fun setAntropometricInfo(body: AntropometricInfo): Flow<Any?> =
        flow { emit(serverApi.setAntropometricInfo(body)) }

    fun updateProfile(body: Profile): Flow<Any?> =
        flow { emit(serverApi.updateProfile(body)) }

    fun logout(): Flow<Any?> =
        flow { emit(serverApi.logout()) }

//    fun signInWithGoogle(): Flow<Any?> =
//        flow { emit(serverApi.signInWithGoogle()) }
}