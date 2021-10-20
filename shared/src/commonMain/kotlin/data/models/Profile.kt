package data.models

import kotlinx.serialization.Serializable


@Serializable
data class Profile(val firstName: String, val secondName: String, val birthday: String, val email: String)
