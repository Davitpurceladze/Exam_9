package com.example.exam_9.presentation.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exam_9.databinding.ItemImageLayoutBinding
import com.example.exam_9.presentation.extension.loadImage
import com.example.exam_9.presentation.model.image.Image

class PagerViewAdapter: ListAdapter<Image, PagerViewAdapter.PlaceViewHolder>(ImageDiffUtil()) {

    inner class PlaceViewHolder(private val binding: ItemImageLayoutBinding): RecyclerView.ViewHolder(binding.root){
        private lateinit var  item: Image
        fun bind(){
            item = currentList[adapterPosition]
            binding.apply {
                imgPlace.loadImage(item.cover)
                tvPlaceName.text = item.location
                tvReactions.text = item.reactionCount.toString()
                tvTitle.text = item.title
                tvPrice.text = item.price
                ratingBar.rating = item.rate?.toFloat() ?: "0".toFloat()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PlaceViewHolder(
        ItemImageLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind()
    }

    class ImageDiffUtil : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }
    }

}