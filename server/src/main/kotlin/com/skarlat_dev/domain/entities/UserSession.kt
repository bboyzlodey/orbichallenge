package com.skarlat_dev.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class UserSession(val session: String)