package com.example.zyneticcodingassessment.domain.usecase

import com.example.zyneticcodingassessment.data.model.Product
import com.example.zyneticcodingassessment.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(id: Int): Product {
        return repository.getProductById(id)
    }
}