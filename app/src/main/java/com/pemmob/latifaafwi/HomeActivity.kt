package com.pemmob.latifaafwi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pemmob.latifaafwi.ui.screen.DaftarProdukScreen
import com.pemmob.latifaafwi.ui.screen.DetailProductScreen
import com.pemmob.latifaafwi.ui.screen.HubungiKamiScreen
import com.pemmob.latifaafwi.ui.theme.JualanTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JualanTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "daftar_produk") {
        composable("daftar_produk") {
            DaftarProdukScreen(navController)
        }
        composable(
            route = "detail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            DetailProductScreen(productId = productId, navController = navController)
        }
        composable("hubungi_kami") {
            HubungiKamiScreen(navController)
        }
    }
}
