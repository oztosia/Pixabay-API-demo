package com.oztosia.pixabay_api_demo.features.pixabayImages.data.repository

import com.oztosia.pixabay_api_demo.features.pixabayImages.domain.model.PixabayImage

interface PixabayImageRepository {
    suspend fun getPixabayImages(q: String?): List<PixabayImage>
}