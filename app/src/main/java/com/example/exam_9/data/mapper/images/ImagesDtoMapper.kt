package com.example.exam_9.data.mapper.images

import com.example.exam_9.data.model.images.ImagesDto
import com.example.exam_9.domain.model.cardview.GetImages

fun ImagesDto.toDomain() =
    GetImages(
        id = id, cover = cover, price = price, title = title, location = location, reactionCount = reactionCount, rate = rate
    )