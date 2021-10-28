package com.skarlat_dev.domain.converters

import com.skarlat_dev.domain.entities.ChallengeEntity
import data.models.Challenge

class ChallengeConverter {

    fun toNetworkModel(bussinesModel: ChallengeEntity): Challenge = bussinesModel.run {
        Challenge(id = id, title = title, description = description)
    }
}