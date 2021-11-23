package data.models

import kotlinx.serialization.Serializable

@Serializable
data class Challenge(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String = ""
)
