package com.example.zyneticcodingassessment.domain.repository

import com.example.zyneticcodingassessment.data.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProductById(id: Int): Product
}