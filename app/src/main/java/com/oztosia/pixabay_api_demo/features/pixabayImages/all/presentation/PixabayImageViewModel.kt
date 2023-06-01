package com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.oztosia.pixabay_api_demo.core.base.BaseViewModel
import com.oztosia.pixabay_api_demo.core.constants.AppConstants
import com.oztosia.pixabay_api_demo.core.error.ErrorMapper
import com.oztosia.pixabay_api_demo.features.pixabayImages.all.presentation.model.PixabayImageDisplayable
import com.oztosia.pixabay_api_demo.features.pixabayImages.domain.GetPixabayImageUseCase
import com.oztosia.pixabay_api_demo.features.pixabayImages.domain.model.PixabayImage

class PixabayImageViewModel(private val getPixabayImageUseCase: GetPixabayImageUseCase,
                            errorMapper: ErrorMapper
                            ): BaseViewModel(errorMapper) {

    private var _query: String = AppConstants.INITIAL_QUERY

    fun setParams(q: String){
        _query = q
        _pixabayImages.also {
            getPixabayImages(it, _query)
        }
    }

    private val _pixabayImages by lazy {
        MutableLiveData<List<PixabayImage>>().also {
            getPixabayImages(it, _query)
        }
    }

    val pixabayImages: LiveData<List<PixabayImageDisplayable>> by lazy {
        _pixabayImages.map { pixabayImages ->
            pixabayImages.map {
                PixabayImageDisplayable(it)
            }
        }
    }

    private fun getPixabayImages(pixabayImageMutableLiveData: MutableLiveData<List<PixabayImage>>, q: String) {
        setPendingState()
        getPixabayImageUseCase(
            params = q,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { pixabayImageMutableLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }

}