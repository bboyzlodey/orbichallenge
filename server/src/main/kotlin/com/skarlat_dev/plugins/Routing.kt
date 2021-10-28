package com.skarlat_dev.plugins

import com.skarlat_dev.domain.repository.ChallengeRepository
import com.skarlat_dev.domain.repository.IChallengesRepository
import com.skarlat_dev.domain.repository.MockChallengeRepository
import com.skarlat_dev.utils.MockHelper
import io.ktor.routing.*
import io.ktor.locations.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import utils.Const

fun Application.configureRouting() {

    routing {
        getChallenges()
        getProfile()
        getAntropometricInfo()
    }
}


fun Routing.getChallenges(): Route = get(Const.GET_CHALLENGES_POINT) {
    val repository: IChallengesRepository = ChallengeRepository()
    call.respond(status = HttpStatusCode.OK, message = repository.getChallenges())
}

fun Routing.getProfile(): Route = get(Const.GET_PROFILE_POINT) {
    val response = MockHelper.getProfile()
    call.respond(status = HttpStatusCode.OK, message = response)
}

fun Routing.getAntropometricInfo(): Route = get(Const.GET_ANTROPOMETRIC_INFO_POINT) {
    val response = MockHelper.getAntropometricInfo()
    call.respond(status = HttpStatusCode.OK, message = response)
}
