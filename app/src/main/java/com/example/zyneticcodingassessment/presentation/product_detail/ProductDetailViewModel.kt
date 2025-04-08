package com.example.zyneticcodingassessment.presentation.product_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zyneticcodingassessment.data.model.Product
import com.example.zyneticcodingassessment.domain.usecase.GetProductByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductByIdUseCase: GetProductByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(ProductDetailState())
    val state: StateFlow<ProductDetailState> = _state.asStateFlow()

    init {
        savedStateHandle.get<Int>("productId")?.let { productId ->
            getProductById(productId)
        }
    }

    private fun getProductById(id: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                val product = getProductByIdUseCase(id)
                _state.update { it.copy(product = product, isLoading = false) }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message ?: "Unknown error", isLoading = false) }
            }
        }
    }
}

data class ProductDetailState(
    val product: Product? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
