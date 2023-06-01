package com.oztosia.pixabay_api_demo.core.di

import com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation.PixabayImageAdapter
import com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation.PixabayImageFragment
import com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation.PixabayImageViewModel
import com.oztosia.pixabay_api_demo.features.pixabayImages.data.repository.PixabayImageRepository
import com.oztosia.pixabay_api_demo.features.pixabayImages.data.repository.PixabayImageRepositoryImpl
import com.oztosia.pixabay_api_demo.features.pixabayImages.details.presentation.details.PixabayImageDetailsFragment
import com.oztosia.pixabay_api_demo.features.pixabayImages.details.presentation.details.PixabayImageDetailsViewModel
import com.oztosia.pixabay_api_demo.features.pixabayImages.dialog.DialogFragment
import com.oztosia.pixabay_api_demo.features.pixabayImages.dialog.DialogViewModel
import com.oztosia.pixabay_api_demo.features.pixabayImages.domain.GetPixabayImageUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    factory<PixabayImageRepository> { PixabayImageRepositoryImpl(get(), get(), get(), get()) }
    factory { GetPixabayImageUseCase(get()) }
    viewModel { PixabayImageViewModel(get(), get())}
    viewModel { DialogViewModel() }
    viewModel { PixabayImageDetailsViewModel() }
    factory { PixabayImageFragment() }
    factory { DialogFragment() }
    factory { PixabayImageDetailsFragment() }
    factory { PixabayImageAdapter() }
}