package com.oztosia.pixabay_api_demo.features.pixabayImages.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.oztosia.pixabay_api_demo.features.pixabayImages.domain.model.PixabayImage

@Entity
data class PixabayImageCached(
    @PrimaryKey val id: Long,
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
) {
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

    companion object

    fun toPixabayImage() = PixabayImage(
        id = id,
        pageURL = pageURL,
        type = type,
        tags = tags,
        previewURL = previewURL,
        previewWidth = previewWidth,
        previewHeight = previewHeight,
        webformatURL = webformatURL,
        webformatWidth = webformatWidth,
        webformatHeight = webformatHeight,
        largeImageURL = largeImageURL,
        fullHDURL = fullHDURL,
        imageURL = imageURL,
        imageWidth = imageWidth,
        imageHeight = imageHeight,
        imageSize = imageSize,
        views = views,
        downloads = downloads,
        likes = likes,
        comments = comments,
        userID = userID,
        user = user,
        userImageURL = userImageURL
    )
}