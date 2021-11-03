package com.skarlat_dev.domain.converters

import com.skarlat_dev.domain.entities.AntropometricInfoEntity
import data.models.AntropometricInfo
import data.models.Sex
import io.netty.util.Mapping

class AntropometricInfoConverter : IAntropometricInfoConverter {

    private fun toNetworkModel(entity: AntropometricInfoEntity): AntropometricInfo =
        AntropometricInfo(sex = Sex.WOMAN, weight = entity.weight, height = entity.height)

    private fun toEntity(networkModel: AntropometricInfo): AntropometricInfoEntity =
        AntropometricInfoEntity(
            id = "",
            userId = "",
            sex = networkModel.sex.identifier,
            weight = networkModel.weight,
            height = networkModel.height
        )

    override val fromEntityToNetwork: Mapping<AntropometricInfoEntity, AntropometricInfo> =
        Mapping { entity -> toNetworkModel(entity) }
    override val fromNetworkToEntity: Mapping<AntropometricInfo, AntropometricInfoEntity> =
        Mapping { network -> toEntity(network) }
}