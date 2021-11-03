package com.skarlat_dev.domain.converters

import com.skarlat_dev.domain.entities.ChallengeEntity
import data.models.Challenge
import io.netty.util.Mapping

interface IChallengeConverter {
    val fromEntityToNetwork: Mapping<ChallengeEntity, Challenge>
}