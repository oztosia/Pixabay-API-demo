package com.oztosia.pixabay_api_demo.core.di

import androidx.room.Room
import com.oztosia.pixabay_api_demo.core.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), AppDatabase::class.java, "app_database"
        ).build()
    }

    single {
        get<AppDatabase>().pixabayImageDao()
    }

}