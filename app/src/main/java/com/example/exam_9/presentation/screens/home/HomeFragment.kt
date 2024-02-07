package com.example.exam_9.presentation.screens.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.exam_9.databinding.FragmentHomeBinding
import com.example.exam_9.presentation.base.BaseFragment
import com.example.exam_9.presentation.event.home.HomeEvents
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()

    override fun bind() {
        fetchImages()

    }

    override fun bindViewActionListeners() {
    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                 viewModel.imageState.collect{
                     println("this is state in home fragment -> $it")
                 }
            }
        }
    }

    private fun fetchImages(){
        viewModel.onEvent(HomeEvents.FetchImages)
    }
}