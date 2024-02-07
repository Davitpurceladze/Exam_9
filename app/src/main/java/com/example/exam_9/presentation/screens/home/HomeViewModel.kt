package com.example.exam_9.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exam_9.data.common.Resource
import com.example.exam_9.domain.usecase.images.ImagesUseCase
import com.example.exam_9.presentation.event.home.HomeEvents
import com.example.exam_9.presentation.mapper.image.toPresenter
import com.example.exam_9.presentation.state.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val imagesUseCase: ImagesUseCase
): ViewModel() {

    private val _imageState = MutableStateFlow(HomeState())
    val imageState: StateFlow<HomeState> = _imageState.asStateFlow()

    fun onEvent(event: HomeEvents){
        when( event) {
            is HomeEvents.FetchImages -> fetchImages()
        }
    }

    private fun fetchImages() {
        viewModelScope.launch {
            imagesUseCase().collect{
                when (it) {
                    is Resource.Loading -> _imageState.update { currentState ->
                        currentState.copy(
                            isLoading = it.isLoading
                        )
                    }

                    is Resource.Failure -> _imageState.update { currentState ->
                        currentState.copy(
                            errorMessage = it.errorMessage
                        )
                    }

                    is Resource.Success -> _imageState.update { currentState ->
                         currentState.copy(
                             image = it.result.map {
                                 it.toPresenter()
                             }
                         )
                    }
                }
            }
        }
    }


}