package com.skarlat_dev.domain.converters

import com.skarlat_dev.domain.entities.AntropometricInfoEntity
import data.models.AntropometricInfo
import io.netty.util.Mapping

interface IAntropometricInfoConverter {
    val fromEntityToNetwork: Mapping<AntropometricInfoEntity, AntropometricInfo>
    val fromNetworkToEntity: Mapping<AntropometricInfo, AntropometricInfoEntity>

}