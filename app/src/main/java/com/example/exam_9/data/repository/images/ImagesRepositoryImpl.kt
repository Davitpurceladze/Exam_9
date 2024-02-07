package com.example.exam_9.data.repository.images

import com.example.exam_9.data.common.HandleResponse
import com.example.exam_9.data.common.Resource
import com.example.exam_9.data.mapper.base.asResource
import com.example.exam_9.data.mapper.images.toDomain
import com.example.exam_9.data.service.ImagesService
import com.example.exam_9.domain.model.cardview.GetImages
import com.example.exam_9.domain.repository.home.ImagesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(
    private val handleResponse: HandleResponse,
    private val imagesService: ImagesService
): ImagesRepository {
    override suspend fun getImages(): Flow<Resource<List<GetImages>>> {

       return handleResponse.safeApiCall {
           imagesService.getImages()
       }.asResource {
            it.map {
                it.toDomain()
            }
       }

    }
}