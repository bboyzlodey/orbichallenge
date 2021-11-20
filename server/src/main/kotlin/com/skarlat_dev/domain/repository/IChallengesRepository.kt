package com.skarlat_dev.domain.repository

import com.skarlat_dev.domain.entities.ChallengeEntity
import data.models.Challenge

interface IChallengesRepository {
    suspend fun getChallenges(): List<ChallengeEntity>
    suspend fun putChallenge(newChallenge: Challenge)
}