package com.skarlat_dev.domain.converters

import com.skarlat_dev.domain.entities.ProfileEntity
import data.models.Profile
import io.netty.util.Mapping

class ProfileConverter : IProfileConverter {
    private fun toNetworkModel(entity: ProfileEntity): Profile =
        Profile(
            firstName = entity.firstName,
            secondName = entity.secondName,
            birthday = entity.birthday,
            email = entity.birthday
        )

    private fun toEntity(networkModel: Profile): ProfileEntity =
        ProfileEntity(
            id = "",
            firstName = networkModel.firstName,
            secondName = networkModel.secondName,
            birthday = networkModel.birthday,
            email = networkModel.email
        )

    override val fromEntityToNetwork: Mapping<ProfileEntity, Profile> =
        Mapping { entity -> toNetworkModel(entity) }

    override val fromNetworkToEntity: Mapping<Profile, ProfileEntity> =
        Mapping { network -> toEntity(network) }
}