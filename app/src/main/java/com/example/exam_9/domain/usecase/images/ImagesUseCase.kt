package com.example.exam_9.domain.usecase.images

import com.example.exam_9.domain.repository.home.ImagesRepository
import javax.inject.Inject

class ImagesUseCase @Inject constructor(
    private val imagesRepository: ImagesRepository
) {
    suspend operator fun invoke() = imagesRepository.getImages()
}

