package com.skarlat_dev.domain.repository

import com.skarlat_dev.utils.MockHelper
import data.models.Challenge

object MockChallengeRepository : IChallengesRepository {
    override fun getChallenges(): List<Challenge> {
        return MockHelper.getChallenges()
    }
}


class ChallengeRepository : IChallengesRepository by MockChallengeRepository {
}
