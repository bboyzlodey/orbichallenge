package com.skarlat_dev.domain.entities

data class ProfileEntity(
    val id: String,
    val firstName: String = "",
    val secondName: String = "",
    val birthday: String = "",
    val email: String = ""
)
