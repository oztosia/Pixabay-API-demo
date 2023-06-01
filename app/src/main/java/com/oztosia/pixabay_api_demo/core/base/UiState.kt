package com.oztosia.pixabay_api_demo.core.base

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}