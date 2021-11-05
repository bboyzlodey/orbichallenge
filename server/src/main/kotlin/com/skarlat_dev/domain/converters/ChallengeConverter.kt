package com.skarlat_dev.domain.converters

import com.skarlat_dev.domain.entities.ChallengeEntity
import data.models.Challenge
import io.netty.util.Mapping

object ChallengeConverter : IChallengeConverter {

    fun toNetworkModel(bussinesModel: ChallengeEntity): Challenge = bussinesModel.run {
        Challenge(id = id, title = title, description = description)
    }

    override val fromEntityToNetwork: Mapping<ChallengeEntity, Challenge> =
        Mapping { entity -> toNetworkModel(entity) }
}