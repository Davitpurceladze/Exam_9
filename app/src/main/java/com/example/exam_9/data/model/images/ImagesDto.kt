package com.example.exam_9.data.model.images

import com.squareup.moshi.Json

data class ImagesDto(
    val id: Int,
    val cover: String,
    val price: String,
    val title: String,
    val location: String,
    @Json(name = "reaction_count")
    val reactionCount: Int,
    val rate: Int?
)
