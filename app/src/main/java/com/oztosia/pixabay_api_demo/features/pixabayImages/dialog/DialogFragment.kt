package com.oztosia.pixabay_api_demo.features.pixabayImages.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.oztosia.pixabay_api_demo.R
import com.oztosia.pixabay_api_demo.core.base.BaseDialogFragment
import com.oztosia.pixabay_api_demo.core.constants.AppConstants.Companion.PIXABAY_IMAGE_DETAILS_KEY
import com.oztosia.pixabay_api_demo.databinding.DialogWindowBinding
import com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation.model.PixabayImageDisplayable
import org.koin.android.ext.android.inject

class DialogFragment: BaseDialogFragment<DialogViewModel>(R.layout.dialog_window) {

    override val viewModel: DialogViewModel by inject()
    private var _binding: DialogWindowBinding? = null
    private val binding get() = _binding!!
    private lateinit var pixabayImage: PixabayImageDisplayable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            if (it != null) {
                pixabayImage =
                    it.getParcelable(PIXABAY_IMAGE_DETAILS_KEY)!!
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = DialogWindowBinding.bind(view)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initViews() {
        super.initViews()
        binding.textViewConfirm.setOnClickListener {
            doPositiveClick()
        }
        binding.textViewReject.setOnClickListener {
            doNegativeClick()
        }
    }

    override fun doPositiveClick() {
        super.doPositiveClick()
        openDialogWindow(pixabayImage)
    }

    private fun openDialogWindow(pixabayImage: PixabayImageDisplayable) {
        val bundle = Bundle()
        bundle.putParcelable(PIXABAY_IMAGE_DETAILS_KEY, pixabayImage)
        findNavController().navigate(R.id.action_navigate_from_dialog_window_to_pixabay_image_details_screen, bundle)
    }

    override fun doNegativeClick() {
        super.doNegativeClick()
        this.dismiss()
    }
}