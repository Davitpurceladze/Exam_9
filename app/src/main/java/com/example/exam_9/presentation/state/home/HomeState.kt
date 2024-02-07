package com.example.exam_9.presentation.state.home

import com.example.exam_9.presentation.model.image.Image

data class HomeState (
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val image: List<Image>? = null

)

