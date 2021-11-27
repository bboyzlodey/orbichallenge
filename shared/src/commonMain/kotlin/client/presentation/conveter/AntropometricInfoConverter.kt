package client.presentation.conveter

import client.business.model.AntropometricInfoBusiness
import client.presentation.model.AntropometricInfoUI
import client.presentation.utils.StringResource
import data.models.Sex

class AntropometricInfoConverter {
    fun toUIModel(business: AntropometricInfoBusiness) : AntropometricInfoUI =
        AntropometricInfoUI(
            weight = business.weight,
            height = business.height,
            sex = when (business.sex) {
                Sex.MAN -> StringResource.SEX_MAN
                Sex.WOMAN -> StringResource.SEX_WOMAN
                else -> StringResource.UNDEFINED
            }
        )

    fun toBusinessModel(uiModel: AntropometricInfoUI) : AntropometricInfoBusiness =
        AntropometricInfoBusiness(
            weight = uiModel.weight,
            height = uiModel.height,
            sex = when (uiModel.sex) {
                StringResource.SEX_MAN -> Sex.MAN
                StringResource.SEX_WOMAN -> Sex.WOMAN
                else -> Sex.NONE
            }
        )
}