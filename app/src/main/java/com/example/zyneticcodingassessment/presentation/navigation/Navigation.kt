package com.example.zyneticcodingassessment.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.zyneticcodingassessment.presentation.navigation.Screen.ProductDetailScreen
import com.example.zyneticcodingassessment.presentation.navigation.Screen.ProductListScreen
import com.example.zyneticcodingassessment.presentation.product_detail.ProductDetailScreen
import com.example.zyneticcodingassessment.presentation.product_list.ProductListScreen


@Composable
fun Navigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = ProductListScreen.route
    ) {
        composable(route = ProductListScreen.route) {
            ProductListScreen(
                onProductClick = { productId ->
                    navController.navigate(ProductDetailScreen.createRoute(productId))
                }
            )
        }

        composable(
            route = ProductDetailScreen.route + "/{productId}",
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.IntType
                }
            )
        ) {
            ProductDetailScreen()
        }
    }
}

sealed class Screen(val route: String) {
    object ProductListScreen : Screen("product_list")
    object ProductDetailScreen : Screen("product_detail") {
        fun createRoute(productId: Int) = "$route/$productId"
    }
}