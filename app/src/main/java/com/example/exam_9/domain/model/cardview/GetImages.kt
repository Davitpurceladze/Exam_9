package com.example.exam_9.domain.model.cardview

data class GetImages(
    val id: Int,
    val cover: String,
    val price: String,
    val title: String,
    val location: String,
    val reactionCount: Int,
     val rate: Int?
)


