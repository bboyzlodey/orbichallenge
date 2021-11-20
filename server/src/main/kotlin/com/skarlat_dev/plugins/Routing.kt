package com.skarlat_dev.plugins

import com.skarlat_dev.domain.converters.ChallengeConverter
import com.skarlat_dev.domain.repository.ChallengeRepository
import com.skarlat_dev.domain.repository.IChallengesRepository
import com.skarlat_dev.utils.MockHelper
import data.models.Challenge
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
    val allChallenges = challengeRepository.getChallenges()
    challengeRepository.putChallenge(newChallenge)
    call.respond(status = HttpStatusCode.OK, "OK")
})
