package com.example.exam_9.presentation.mapper.image

import com.example.exam_9.domain.model.cardview.GetImages
import com.example.exam_9.presentation.model.image.Image

fun GetImages.toPresenter() = Image(
    id = id, cover = cover, price = price, title = title, location = location, reactionCount = reactionCount, rate = rate

)