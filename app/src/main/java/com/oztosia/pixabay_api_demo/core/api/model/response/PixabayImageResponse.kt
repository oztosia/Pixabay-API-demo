package com.oztosia.pixabay_api_demo.core.api.model.response

import com.google.gson.annotations.SerializedName
import com.oztosia.pixabay_api_demo.features.pixabayImages.domain.model.PixabayImage

data class PixabayImageResponse(
    @SerializedName("total") val total: Int,
    @SerializedName("totalHits") val totalHits: Int,
    @SerializedName("hits") val hits: List<PixabayImage>
){
    companion object
}