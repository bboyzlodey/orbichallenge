package com.skarlat_dev.domain.converters

import com.skarlat_dev.domain.entities.AntropometricInfoEntity
import data.models.AntropometricInfo
import data.models.Sex

class AntropometricInfoConverter {

    fun toNetworkModel(entity: AntropometricInfoEntity): AntropometricInfo =
        AntropometricInfo(sex = Sex.WOMAN, weight = entity.weight, height = entity.height)

    fun toEntity(networkModel: AntropometricInfo) : AntropometricInfoEntity =
        AntropometricInfoEntity(id = "", userId = "", sex = networkModel.sex.identifier, weight = networkModel.weight, height = networkModel.height)
}