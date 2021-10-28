package com.skarlat_dev.domain.entities

data class AntropometricInfoEntity(
    val id: String,
    val userId: String,
    val sex: String,
    val weight: Float,
    val height: Int
)
