package com.example.exam_9.data.service

import com.example.exam_9.data.model.images.ImagesDto
import retrofit2.Response
import retrofit2.http.GET

interface ImagesService {

    @GET("0545ddc1-c487-46ce-b70c-5b95270d6b76")
    suspend fun getImages() : Response<List<ImagesDto>>
}