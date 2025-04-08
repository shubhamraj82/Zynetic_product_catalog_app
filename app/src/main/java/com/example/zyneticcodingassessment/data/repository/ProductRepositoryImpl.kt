package com.example.zyneticcodingassessment.data.repository

import com.example.zyneticcodingassessment.data.model.Product
import com.example.zyneticcodingassessment.data.remote.ProductApi
import com.example.zyneticcodingassessment.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return api.getProducts().products
    }

    override suspend fun getProductById(id: Int): Product {
        return api.getProductById(id)
    }
}