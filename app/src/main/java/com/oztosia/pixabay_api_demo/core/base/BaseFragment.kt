package com.oztosia.pixabay_api_demo.core.base

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<T : BaseViewModel>(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    abstract val viewModel: T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        bindViewModelToLifecycle()
    }

    open fun initViews() {}
    open fun initObservers() {
        observeUiState()
    }

    private fun bindViewModelToLifecycle() {
        lifecycle.addObserver(viewModel)
    }


    private fun observeUiState() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                UiState.Idle -> onIdleState()
                UiState.Pending -> onPendingState()
                else -> {}
            }
        }
    }

    open fun onIdleState() {}
    open fun onPendingState() {}

    protected fun showSnackbar(view: View, message: CharSequence){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            .setBackgroundTint(Color.GRAY)
            .setTextColor(Color.WHITE)
            .show()
    }

    protected fun showToast(@StringRes stringRes: Int) {
        showToast(getString(stringRes))
    }

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}