package data.models

import kotlinx.serialization.Serializable

@Serializable
data class AntropometricInfo(val sex: Sex, val weight: Float, val height: Int)
