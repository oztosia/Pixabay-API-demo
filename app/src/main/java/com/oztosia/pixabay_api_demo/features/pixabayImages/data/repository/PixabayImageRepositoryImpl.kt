package com.oztosia.pixabay_api_demo.features.pixabayImages.data.repository


import com.oztosia.pixabay_api_demo.core.api.PixabayImagesApi
import com.oztosia.pixabay_api_demo.core.error.ErrorWrapper
import com.oztosia.pixabay_api_demo.core.error.callOrThrow
import com.oztosia.pixabay_api_demo.features.pixabayImages.data.local.PixabayImageDao
import com.oztosia.pixabay_api_demo.features.pixabayImages.data.local.model.PixabayImageCached
import com.oztosia.pixabay_api_demo.features.pixabayImages.domain.model.PixabayImage
import com.oztosia.pixabay_api_demo.core.network.NetworkStateProvider


class PixabayImageRepositoryImpl(
    private val pixabayImagesApi: PixabayImagesApi,
    private val pixabayImageDao: PixabayImageDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : PixabayImageRepository {

    override suspend fun getPixabayImages(q: String?): List<PixabayImage> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) {
                getPixabayImagesFromRemote(q!!)
            }.also {
                savePixabayImagesToLocal(it)
            }
        } else {
            getPixabayImagesFromLocal(q!!)
        }
    }


    private suspend fun getPixabayImagesFromRemote(q: String): List<PixabayImage> {
        return pixabayImagesApi.getPixabayImages(q).hits
    }

    private suspend fun savePixabayImagesToLocal(pixabayImages: List<PixabayImage>) {
        pixabayImages.map {
            PixabayImageCached(it)
        }.toTypedArray().let {
            pixabayImageDao.savePixabayImages(*it)
        }
    }

    private suspend fun getPixabayImagesFromLocal(q: String): List<PixabayImage> {
        return pixabayImageDao.getPixabayImages(q).map {
            it.toPixabayImage()
        }
    }
}