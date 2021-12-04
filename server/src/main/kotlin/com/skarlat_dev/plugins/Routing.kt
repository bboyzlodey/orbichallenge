package com.skarlat_dev.plugins

import com.skarlat_dev.domain.converters.ChallengeConverter
import com.skarlat_dev.domain.repository.ChallengeRepository
import com.skarlat_dev.domain.repository.IChallengesRepository
import com.skarlat_dev.utils.MockHelper
import data.models.Challenge
import data.request.GetStepRecordsRequest
import data.request.SignWithGoogleRequest
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import utils.Const

fun Application.configureRouting() {

    routing {
        getChallenges()
        getProfile()
        getAntropometricInfo()
        putChallenge()
        signInWithGoogle()
    }
}

private val challengeRepository: IChallengesRepository = ChallengeRepository()

fun Routing.getChallenges(): Route = get(Const.GET_CHALLENGES_POINT) {
    val challenges = challengeRepository.getChallenges()
    val converter = ChallengeConverter
    call.respond(status = HttpStatusCode.OK, message = challenges.map(converter::toNetworkModel))
}

fun Routing.getProfile(): Route = get(Const.GET_PROFILE_POINT) {
    val response = MockHelper.getProfile()
    call.respond(status = HttpStatusCode.OK, message = response)
}

fun Routing.getAntropometricInfo(): Route = get(Const.GET_ANTROPOMETRIC_INFO_POINT) {
    val response = MockHelper.getAntropometricInfo()
    call.respond(status = HttpStatusCode.OK, message = response)
}

fun Routing.putChallenge(): Route = put("/challenge", body = {
    val newChallenge = call.receive<Challenge>()
    challengeRepository.putChallenge(newChallenge)
    call.respond(status = HttpStatusCode.OK, "OK")
})

private val authInteractor = AuthInteractor(
    profileConverter = ProfileConverter(),
    profileRepository = ProfileRepository()
)

fun Routing.signInWithGoogle(): Route = post(Const.SIGN_IN_WITH_GOOGLE_POINT, body = {
    val request = call.receive<SignWithGoogleRequest>()
    val token = authInteractor.authenticateByGoogleToken(request.token)
    call.respond(status = HttpStatusCode.OK, message = token)
})
