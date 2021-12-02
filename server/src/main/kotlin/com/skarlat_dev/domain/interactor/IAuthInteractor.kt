package com.skarlat_dev.domain.interactor

interface IAuthInteractor {
    suspend fun authenticateByGoogleToken(token: String) : String
}