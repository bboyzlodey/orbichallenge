package data.network

import data.models.AntropometricInfo
import data.models.Challenge
import data.models.Profile
import data.models.StepRecord
import data.response.GetStepRecordsResponse
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import utils.Const

class ServerApiClient : ServerApi {

    private val client = HttpClient {
        install(JsonFeature) {
            acceptContentTypes = listOf(ContentType.Application.Json)
            serializer = KotlinxSerializer()
        }
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.BODY
        }
        engine { proxy = ProxyBuilder.http(Const.TEST_SERVER_HOST) }
    }

    override suspend fun getStepRecords(): GetStepRecordsResponse {
        return client.get(Const.GET_STEP_RECORDS_POINT)
    }

    override suspend fun getChallenges(): List<Challenge> {
        return client.get(Const.GET_CHALLENGES_POINT)
    }

    override suspend fun getProfile(): Profile {
        return client.get {
            this.method = HttpMethod(Const.GET_PROFILE_POINT)
        }
    }

    override suspend fun getAntropometricInfo(): AntropometricInfo {
        return client.get {
            this.method = HttpMethod(Const.GET_STEP_RECORD_POINT)
        }
    }

    override suspend fun sendStepRecord(body: StepRecord): Any? {
        return client.put {
            this.body = body
            this.method = HttpMethod(Const.PUSH_STEP_RECORD_POINT)
        }
    }

    override suspend fun sendStepRecords(body: List<StepRecord>): Any? {
        return client.put {
            this.body = body
            this.method = HttpMethod(Const.PUSH_STEP_RECORDS_POINT)
        }
    }

    override suspend fun setAntropometricInfo(body: AntropometricInfo): Any? {
        return client.put {
            this.body = body
            this.method = HttpMethod(Const.PUSH_ANTROPOMETRIC_INFO_POINT)
        }
    }

    override suspend fun updateProfile(body: Profile): Any? {
        return client.put {
            this.body = body
            this.method = HttpMethod(Const.PUSH_PROFILE_POINT)
        }
    }

    override suspend fun logout(): Any? {
        return client.get {
            this.method = HttpMethod(Const.LOGOUT_POINT)
        }
    }

    override suspend fun signInWithGoogle(): Any? {
        return client.get {
            this.method = HttpMethod(Const.SIGN_IN_WITH_GOOGLE_POINT)
        }
    }
}