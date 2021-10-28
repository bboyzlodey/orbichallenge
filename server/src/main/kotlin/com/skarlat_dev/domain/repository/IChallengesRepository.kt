package com.skarlat_dev.domain.repository

import data.models.Challenge

interface IChallengesRepository {

    fun getChallenges() : List<Challenge>
}