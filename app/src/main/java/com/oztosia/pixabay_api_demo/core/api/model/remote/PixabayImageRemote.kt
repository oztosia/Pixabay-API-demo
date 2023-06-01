package com.oztosia.pixabay_api_demo.core.api.model.remote

import com.google.gson.annotations.SerializedName
import com.oztosia.pixabay_api_demo.features.pixabayImages.domain.model.PixabayImage

data class PixabayImageRemote(
    @SerializedName("id") val id: Long,
    @SerializedName("pageURL") val pageURL: String,
    @SerializedName("type") val type: String,
    @SerializedName("tags") val tags: String,
    @SerializedName("previewURL") val previewURL: String,
    @SerializedName("previewWidth") val previewWidth: Long,
    @SerializedName("previewHeight") val previewHeight: Long,
    @SerializedName("webformatURL") val webformatURL: String,
    @SerializedName("webformatWidth") val webformatWidth: Long,
    @SerializedName("webformatHeight") val webformatHeight: Long,
    @SerializedName("largeImageURL") val largeImageURL: String,
    @SerializedName("fullHDURL") val fullHDURL: String,
    @SerializedName("imageURL") val imageURL: String,
    @SerializedName("imageWidth") val imageWidth: Long,
    @SerializedName("imageHeight") val imageHeight: Long,
    @SerializedName("imageSize") val imageSize: Long,
    @SerializedName("views") val views: Long,
    @SerializedName("downloads") val downloads: Long,
    @SerializedName("likes") val likes: Long,
    @SerializedName("comments") val comments: Long,
    @SerializedName("user_id") val userID: Long,
    @SerializedName("user") val user: String,
    @SerializedName("userImageURL") val userImageURL: String
) {
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