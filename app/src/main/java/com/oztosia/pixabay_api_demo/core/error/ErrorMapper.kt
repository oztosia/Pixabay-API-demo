package com.oztosia.pixabay_api_demo.core.error

interface ErrorMapper {
    fun map(throwable: Throwable): String
}