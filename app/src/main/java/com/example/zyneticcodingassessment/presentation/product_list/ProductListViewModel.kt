package com.example.zyneticcodingassessment.presentation.product_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zyneticcodingassessment.data.model.Product
import com.example.zyneticcodingassessment.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ProductListState())
    val state: StateFlow<ProductListState> = _state.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                val products = getProductsUseCase()
                _state.update { it.copy(products = products, isLoading = false) }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message ?: "Unknown error", isLoading = false) }
            }
        }
    }
}

data class ProductListState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
