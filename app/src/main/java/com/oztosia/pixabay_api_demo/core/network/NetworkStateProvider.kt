package com.oztosia.pixabay_api_demo.core.network

interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}