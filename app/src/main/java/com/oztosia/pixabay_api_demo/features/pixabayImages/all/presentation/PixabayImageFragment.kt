package com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.oztosia.pixabay_api_demo.R
import com.oztosia.pixabay_api_demo.core.base.BaseFragment
import com.oztosia.pixabay_api_demo.core.constants.AppConstants
import com.oztosia.pixabay_api_demo.databinding.FragmentPixabayImageBinding
import com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation.model.PixabayImageDisplayable
import org.koin.android.ext.android.inject


class PixabayImageFragment : BaseFragment<PixabayImageViewModel>(R.layout.fragment_pixabay_image)
    , SearchView.OnQueryTextListener{

    override val viewModel: PixabayImageViewModel by inject()
    private val pixabayImageAdapter: PixabayImageAdapter by inject()

    private var _binding: FragmentPixabayImageBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentPixabayImageBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initViews() {
        super.initViews()
        initRecycler()
        initSearchView()
    }

    private fun initRecycler() {
        with(binding.recyclerView) {
           val flexboxLayoutManager = FlexboxLayoutManager(context).apply {
                flexDirection = FlexDirection.ROW
                flexWrap = FlexWrap.WRAP
                justifyContent = JustifyContent.CENTER
                alignItems = AlignItems.STRETCH
            }
            layoutManager = flexboxLayoutManager
            pixabayImageAdapter.onClickItem = ::onPixabayImageClick
            adapter = pixabayImageAdapter
        }
    }

    private fun initSearchView() {
        binding.search.isIconified
        binding.search.imeOptions = EditorInfo.IME_ACTION_DONE
        binding.search.setOnQueryTextListener(this)
        }

    override fun onQueryTextSubmit(q: String?): Boolean {
        viewModel.setParams(q!!)
        observePixabayImages()
        return false
    }

    override fun onQueryTextChange(q: String?): Boolean {
        return false
    }

    override fun initObservers() {
        super.initObservers()
        observePixabayImages()
    }

    override fun onIdleState() {
        super.onIdleState()
        binding.progressBar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        val progressAnimator = ObjectAnimator.ofInt(binding.progressBar, "progress", 0, 100)
        progressAnimator.duration = 2000
        progressAnimator.interpolator = LinearInterpolator()
        progressAnimator.start()
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun observePixabayImages() {
        viewModel.pixabayImages.observe(viewLifecycleOwner) {
            pixabayImageAdapter.submitList(it)
        }
    }

    private fun openDialogWindow(pixabayImage: PixabayImageDisplayable) {
        val bundle = Bundle()
        bundle.putParcelable(AppConstants.PIXABAY_IMAGE_DETAILS_KEY, pixabayImage)
        findNavController().navigate(R.id.action_navigate_from_pixabay_image_screen_to_dialog_window, bundle)
    }

    private fun onPixabayImageClick(pixabayImage: PixabayImageDisplayable) {
        openDialogWindow(pixabayImage)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}