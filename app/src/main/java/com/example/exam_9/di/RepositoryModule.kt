package com.example.exam_9.di

import com.example.exam_9.data.common.HandleResponse
import com.example.exam_9.data.repository.images.ImagesRepositoryImpl
import com.example.exam_9.data.service.ImagesService
import com.example.exam_9.domain.repository.home.ImagesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideImagesRepository(handleResponse: HandleResponse, imagesService: ImagesService) : ImagesRepository{
        return ImagesRepositoryImpl(handleResponse, imagesService)
    }
}