package com.balbasio.cryptoappjetpackcompose

import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.balbasio.cryptoappjetpackcompose.ui.theme.CryptoCrazyComposeTheme
import com.balbasio.cryptoappjetpackcompose.view.CryptoDetailScreen
import com.balbasio.cryptoappjetpackcompose.view.CryptoListScreen


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCrazyComposeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "crypto_list_screen"
                ) {
                    composable("crypto_list_screen") {
                        CryptoListScreen(navController = navController)
                    }
                    composable(
                        "crypto_detail_screen/{cryptoId}/{cryptoPrice}",
                        arguments = listOf(
                            navArgument("cryptoId") {
                                type = NavType.StringType
                            },
                            navArgument("cryptoPrice") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val cryptoId = remember {
                            it.arguments?.getString("cryptoId")
                        }
                        val cryptoPrice = remember {
                            it.arguments?.getString("cryptoPrice")
                        }
                        CryptoDetailScreen(
                            id = cryptoId ?: "",
                            price = cryptoPrice ?: "",
                            navController = navController
                        )
                    }
                }
            }
        }



    }
}