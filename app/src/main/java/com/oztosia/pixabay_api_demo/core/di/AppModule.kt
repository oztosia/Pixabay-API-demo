package com.oztosia.pixabay_api_demo.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.oztosia.pixabay_api_demo.core.error.ErrorMapper
import com.oztosia.pixabay_api_demo.core.error.ErrorMapperImpl
import com.oztosia.pixabay_api_demo.core.error.ErrorWrapper
import com.oztosia.pixabay_api_demo.core.error.ErrorWrapperImpl
import com.oztosia.pixabay_api_demo.core.network.NetworkStateProvider
import com.oztosia.pixabay_api_demo.core.network.NetworkStateProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory { LinearLayoutManager(androidContext()) }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory <ErrorWrapper>{ ErrorWrapperImpl() }
    factory <ErrorMapper>{ ErrorMapperImpl(androidContext()) }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
    }