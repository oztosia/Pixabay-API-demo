package com.oztosia.pixabay_api_demo.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oztosia.pixabay_api_demo.features.pixabayImages.data.local.PixabayImageDao
import com.oztosia.pixabay_api_demo.features.pixabayImages.data.local.model.PixabayImageCached


@Database(entities = [PixabayImageCached::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pixabayImageDao(): PixabayImageDao
}