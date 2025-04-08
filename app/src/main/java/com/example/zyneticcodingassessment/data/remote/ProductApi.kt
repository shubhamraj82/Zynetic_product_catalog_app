package com.example.zyneticcodingassessment.data.remote

import com.example.zyneticcodingassessment.data.model.Product
import com.example.zyneticcodingassessment.data.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): ProductResponse

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product
}
