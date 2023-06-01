package com.oztosia.pixabay_api_demo.features.pixabayImages.domain.model

data class PixabayImage(
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
)
