package co.touchlab.shared

import kotlinx.serialization.Serializable

@Serializable
internal data class ImageResult(
    val status:String,
    val message: String
)