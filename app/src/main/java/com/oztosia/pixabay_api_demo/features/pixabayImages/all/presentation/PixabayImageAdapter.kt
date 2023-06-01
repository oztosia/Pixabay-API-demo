package com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oztosia.pixabay_api_demo.databinding.ItemPixabayImageBinding
import com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation.model.PixabayImageDisplayable


class PixabayImageAdapter :
    ListAdapter<PixabayImageDisplayable, PixabayImageAdapter.PixabayImageViewHolder>(PixabayImageDiffCallback) {

    var onClickItem: ((PixabayImageDisplayable) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PixabayImageViewHolder(
        ItemPixabayImageBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClickItem
    )

    override fun onBindViewHolder(holder: PixabayImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PixabayImageViewHolder(
        private val binding: ItemPixabayImageBinding,
        private val onClickItem: ((PixabayImageDisplayable) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pixabayImage: PixabayImageDisplayable) {
            binding.username.text = pixabayImage.user
            binding.hashtags.text = pixabayImage.tags
            Glide.with(binding.thumbnail.context)
                .load(pixabayImage.largeImageURL)
                .centerCrop()
                .into(binding.thumbnail)
            binding.root.setOnClickListener { onClickItem?.invoke(pixabayImage) }
        }
    }

    object PixabayImageDiffCallback : DiffUtil.ItemCallback<PixabayImageDisplayable>() {
        override fun areItemsTheSame(oldItem: PixabayImageDisplayable, newItem: PixabayImageDisplayable) =
            (oldItem.toString() == newItem.toString())

        override fun areContentsTheSame(oldItem: PixabayImageDisplayable, newItem: PixabayImageDisplayable) =
            (oldItem == newItem)
    }
}