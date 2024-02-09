package com.example.exam_9.presentation.screens.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.exam_9.data.common.Resource
import com.example.exam_9.databinding.FragmentHomeBinding
import com.example.exam_9.presentation.base.BaseFragment
import com.example.exam_9.presentation.event.home.HomeEvents
import com.example.exam_9.presentation.state.home.HomeState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.math.abs

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var pagerAdapter: PagerViewAdapter

    override fun bind() {
        fetchImages()
        bindViewPager()
    }

    override fun bindViewActionListeners() {
    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                 viewModel.imageState.collect{
                     handleHomeState(it)
                 }
            }
        }
    }

    private fun bindViewPager() {
        pagerAdapter = PagerViewAdapter()

        binding.viewPager2.apply {
            adapter = pagerAdapter

            offscreenPageLimit = 3
            clipToPadding = false
            clipChildren = false
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        }

    }

    private fun fetchImages(){
        viewModel.onEvent(HomeEvents.FetchImages)
    }

    private fun handleHomeState(state: HomeState) {
        state.image?.let{
            pagerAdapter.submitList(it)
        }
    }
}