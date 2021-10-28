package com.skarlat_dev.domain.converters

import com.skarlat_dev.domain.entities.ProfileEntity
import com.skarlat_dev.domain.entities.StepRecordEntity
import data.models.Profile
import data.models.StepRecord
import java.util.*

class ProfileConverter {
    fun toNetworkModel(entity: ProfileEntity): Profile =
        Profile(
            firstName = entity.firstName,
            secondName = entity.secondName,
            birthday = entity.birthday,
            email = entity.birthday
        )

    fun toEntity(networkModel: Profile): ProfileEntity =
        ProfileEntity(
            id = "",
            firstName = networkModel.firstName,
            secondName = networkModel.secondName,
            birthday = networkModel.birthday,
            email = networkModel.email
        )
}