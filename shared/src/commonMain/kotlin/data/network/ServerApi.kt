package data.network

import data.models.AntropometricInfo
import data.models.Challenge
import data.models.Profile
import data.models.StepRecord
import data.response.GetStepRecordsResponse

interface ServerApi {

    suspend fun getStepRecords(): GetStepRecordsResponse

    suspend fun getChallenges(): List<Challenge>

    suspend fun getProfile(): Profile

    suspend fun getAntropometricInfo(): AntropometricInfo

    suspend fun sendStepRecord(body: StepRecord): Any?

    suspend fun sendStepRecords(body: List<StepRecord>): Any?

    suspend fun setAntropometricInfo(body: AntropometricInfo): Any?

    suspend fun updateProfile(body: Profile): Any?

    suspend fun logout(): Any?

    suspend fun signInWithGoogle(): Any?
}