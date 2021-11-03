package com.skarlat_dev.domain.converters

import com.skarlat_dev.domain.entities.ProfileEntity
import data.models.Profile
import io.netty.util.Mapping

interface IProfileConverter {
    val fromEntityToNetwork: Mapping<ProfileEntity, Profile>
    val fromNetworkToEntity: Mapping<Profile, ProfileEntity>
}