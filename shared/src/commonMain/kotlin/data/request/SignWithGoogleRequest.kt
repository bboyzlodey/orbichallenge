package data.request

import kotlinx.serialization.Serializable

@Serializable
data class SignWithGoogleRequest(val token: String)
