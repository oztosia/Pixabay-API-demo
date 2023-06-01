package com.oztosia.pixabay_api_demo.core.di

import com.oztosia.pixabay_api_demo.di.appModule
import org.koin.core.module.Module

val koinInjector: List<Module> =
    presentationModule
    .plus(appModule)
    .plus(networkModule)
    .plus(databaseModule)