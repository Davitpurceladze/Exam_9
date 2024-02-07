package com.example.exam_9.domain.repository.home

import com.example.exam_9.data.common.Resource
import com.example.exam_9.domain.model.cardview.GetImages
import kotlinx.coroutines.flow.Flow

interface ImagesRepository {

    suspend fun getImages() : Flow<Resource<List<GetImages>>>
}