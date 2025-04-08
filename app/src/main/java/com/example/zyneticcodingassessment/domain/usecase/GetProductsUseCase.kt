package com.example.zyneticcodingassessment.domain.usecase

import com.example.zyneticcodingassessment.data.model.Product
import com.example.zyneticcodingassessment.domain.repository.ProductRepository
import javax.inject.Inject
class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): List<Product> {
        return repository.getProducts()
    }
}