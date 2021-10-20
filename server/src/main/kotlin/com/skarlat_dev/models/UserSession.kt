package com.skarlat_dev.models

import kotlinx.serialization.Serializable

@Serializable
data class UserSession(val session: String)