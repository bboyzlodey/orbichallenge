package data.network

import data.models.AntropometricInfo
import data.models.Challenge
import data.models.Profile
import data.models.StepRecord

interface ServerApi {

    fun getStepRecords(): List<StepRecord>

    fun getChallenges(): List<Challenge>

    fun getProfile(): Profile

    fun getAntropometricInfo(): AntropometricInfo

    fun sendStepRecord(body: StepRecord): Any?

    fun sendStepRecords(body: List<StepRecord>): Any?

    fun setAntropometricInfo(body: AntropometricInfo): Any?

    fun updateProfile(body: Profile): Any?

    fun logout(): Any?

    fun signInWithGoogle(): Any?
}