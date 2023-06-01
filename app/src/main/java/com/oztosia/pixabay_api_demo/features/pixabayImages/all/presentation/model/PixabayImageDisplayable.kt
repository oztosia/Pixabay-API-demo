package com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation.model

import android.os.Parcelable
import com.oztosia.pixabay_api_demo.features.pixabayImages.domain.model.PixabayImage

import kotlinx.parcelize.Parcelize
import kotlin.reflect.KFunction1
import kotlin.reflect.KParameter
import kotlin.reflect.KType
import kotlin.reflect.KTypeParameter
import kotlin.reflect.KVisibility

@Parcelize
data class PixabayImageDisplayable(
    val id: Long,
    val pageURL: String,
    val type: String,
    val tags: String,
    val previewURL: String,
    val previewWidth: Long,
    val previewHeight: Long,
    val webformatURL: String,
    val webformatWidth: Long,
    val webformatHeight: Long,
    val largeImageURL: String,
    val fullHDURL: String?,
    val imageURL: String?,
    val imageWidth: Long,
    val imageHeight: Long,
    val imageSize: Long,
    val views: Long,
    val downloads: Long,
    val likes: Long,
    val comments: Long,
    val userID: Long,
    val user: String,
    val userImageURL: String
) : Parcelable {
    constructor(pixabayImage: PixabayImage) : this(
        id = pixabayImage.id,
        pageURL = pixabayImage.pageURL,
        type = pixabayImage.type,
        tags = pixabayImage.tags,
        previewURL = pixabayImage.previewURL,
        previewWidth = pixabayImage.previewWidth,
        previewHeight = pixabayImage.previewHeight,
        webformatURL = pixabayImage.webformatURL,
        webformatWidth = pixabayImage.webformatWidth,
        webformatHeight = pixabayImage.webformatHeight,
        largeImageURL = pixabayImage.largeImageURL,
        fullHDURL = pixabayImage.fullHDURL,
        imageURL = pixabayImage.imageURL,
        imageWidth = pixabayImage.imageWidth,
        imageHeight = pixabayImage.imageHeight,
        imageSize = pixabayImage.imageSize,
        views = pixabayImage.views,
        downloads = pixabayImage.downloads,
        likes = pixabayImage.likes,
        comments = pixabayImage.comments,
        userID = pixabayImage.userID,
        user = pixabayImage.user,
        userImageURL = pixabayImage.userImageURL
    )
}