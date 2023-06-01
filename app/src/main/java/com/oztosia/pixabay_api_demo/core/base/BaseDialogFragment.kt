package com.oztosia.pixabay_api_demo.core.base

import android.R
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment


abstract class BaseDialogFragment<T : BaseViewModel>(@LayoutRes layoutRes: Int) : DialogFragment(layoutRes) {

    abstract val viewModel: T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        bindViewModelToLifecycle()
    }

    open fun initViews() {}

    open fun initObservers() {}

    open fun doPositiveClick() {}

    open fun doNegativeClick() {}

    private fun bindViewModelToLifecycle() {
        lifecycle.addObserver(viewModel)
    }
}
