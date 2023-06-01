package com.oztosia.pixabay_api_demo.features.pixabayImages.domain

import com.oztosia.pixabay_api_demo.core.base.UseCase
import com.oztosia.pixabay_api_demo.features.pixabayImages.data.repository.PixabayImageRepository
import com.oztosia.pixabay_api_demo.features.pixabayImages.domain.model.PixabayImage

class GetPixabayImageUseCase(
    private val pixabayImagesRepository: PixabayImageRepository
) : UseCase<List<PixabayImage>, String>() {
    override suspend fun action(params: String) = pixabayImagesRepository.getPixabayImages(params)
}