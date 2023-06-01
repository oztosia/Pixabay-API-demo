package com.oztosia.pixabay_api_demo.core.error

interface ErrorWrapper{
    fun wrap(throwable: Throwable): Throwable
}