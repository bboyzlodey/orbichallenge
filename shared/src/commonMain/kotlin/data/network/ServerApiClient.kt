package data.network

import data.models.AntropometricInfo
import data.models.Challenge
import data.models.Profile
import data.models.StepRecord
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

class ServerApiClient : ServerApi {

    private val client = HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        engine { proxy = ProxyBuilder.http("localhost:8080") }
    }

    override suspend fun getStepRecords(): List<StepRecord> {
        return client.get("/stepRecords")
    }

    override suspend fun getChallenges(): List<Challenge> {
        return client.get("/challenges")
    }

    override suspend fun getProfile(): Profile {
        return client.get {
            this.method = HttpMethod("/profile")
        }
    }

    override suspend fun getAntropometricInfo(): AntropometricInfo {
        return client.get {
            this.method = HttpMethod("/antropometricInfo")
        }
    }

    override suspend fun sendStepRecord(body: StepRecord): Any? {
        return client.put {
            this.body = body
            this.method = HttpMethod("/sendStepRecord")
        }
    }

    override suspend fun sendStepRecords(body: List<StepRecord>): Any? {
        return client.put {
            this.body = body
            this.method = HttpMethod("/sendStepRecords")
        }
    }

    override suspend fun setAntropometricInfo(body: AntropometricInfo): Any? {
        return client.put {
            this.body = body
            this.method = HttpMethod("/setAntropometricInfo")
        }
    }

    override suspend fun updateProfile(body: Profile): Any? {
        return client.put {
            this.body = body
            this.method = HttpMethod("/updateProfile")
        }
    }

    override suspend fun logout(): Any? {
        return client.get {
            this.method = HttpMethod("/logout")
        }
    }

    override suspend fun signInWithGoogle(): Any? {
        return client.get {
            this.method = HttpMethod("/signInWithGoogle")
        }
    }
}