package com.skarlat_dev.domain.repository

import data.models.Challenge

interface IChallengesRepository {
    suspend fun getChallenges() : List<Challenge>
}