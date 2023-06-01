package com.oztosia.pixabay_api_demo.features.pixabayImages.details.presentation.details

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.oztosia.pixabay_api_demo.R
import com.oztosia.pixabay_api_demo.core.base.BaseFragment
import com.oztosia.pixabay_api_demo.core.constants.AppConstants
import com.oztosia.pixabay_api_demo.core.constants.AppConstants.Companion.PIXABAY_IMAGE_DETAILS_KEY
import com.oztosia.pixabay_api_demo.databinding.FragmentPixabayImageBinding
import com.oztosia.pixabay_api_demo.databinding.FragmentPixabayImageDetailsBinding
import com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation.PixabayImageViewModel
import com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation.model.PixabayImageDisplayable
import com.oztosia.pixabay_api_demo.features.pixabayImages.domain.model.PixabayImage
import org.koin.android.ext.android.inject

@Suppress("DEPRECATION")
class PixabayImageDetailsFragment: BaseFragment<PixabayImageDetailsViewModel>(R.layout.fragment_pixabay_image_details){

    override val viewModel: PixabayImageDetailsViewModel by inject()
    private var _binding: FragmentPixabayImageDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var pixabayImage: PixabayImageDisplayable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        arguments.let {
            if (it != null) {
                pixabayImage =
                    it.getParcelable(PIXABAY_IMAGE_DETAILS_KEY)!!
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentPixabayImageDetailsBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(PIXABAY_IMAGE_DETAILS_KEY, pixabayImage)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let {
            pixabayImage = it.getParcelable(PIXABAY_IMAGE_DETAILS_KEY)!!
            initData(pixabayImage)
        }
    }

    override fun initViews() {
        super.initViews()
        try{initData(pixabayImage)}
        catch(_: Exception){}
    }

    private fun initData(pixabayImage: PixabayImageDisplayable) {
        pixabayImage.let {
            Glide.with(binding.image!!.context)
                .load(pixabayImage.largeImageURL)
                .into(binding.image!!)
            binding.username.text = pixabayImage.user
            binding.hashtags.text = pixabayImage.tags
            binding.comments.text = pixabayImage.comments.toString()
            binding.downloads.text = pixabayImage.downloads.toString()
            binding.likes.text = pixabayImage.likes.toString()
        }
    }

}