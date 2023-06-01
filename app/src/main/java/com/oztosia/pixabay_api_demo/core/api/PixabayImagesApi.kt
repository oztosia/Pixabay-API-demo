package com.oztosia.pixabay_api_demo.core.api

import com.oztosia.pixabay_api_demo.core.api.model.response.PixabayImageResponse
import com.oztosia.pixabay_api_demo.core.constants.AppConstants.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayImagesApi {

    @GET ("?key=$API_KEY")
    suspend fun getPixabayImages(@Query("q") query: String?): PixabayImageResponse
}