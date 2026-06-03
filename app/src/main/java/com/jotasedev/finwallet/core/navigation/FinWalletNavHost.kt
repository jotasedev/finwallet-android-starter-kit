package com.jotasedev.finwallet.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jotasedev.finwallet.feature.auth.presentation.LoginScreen
import com.jotasedev.finwallet.feature.auth.presentation.OtpScreen
import com.jotasedev.finwallet.feature.home.presentation.HomeScreen
import com.jotasedev.finwallet.feature.receipt.presentation.ReceiptScreen
import com.jotasedev.finwallet.feature.transactions.presentation.TransactionsScreen
import com.jotasedev.finwallet.feature.transfer.presentation.TransferScreen

@Composable
fun FinWalletNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginDestination
    ){
        composable<LoginDestination> {
            LoginScreen { navController.navigate(OtpDestination) }
        }

        composable<OtpDestination> {
            OtpScreen { navController.navigate(HomeDestination)
                {
                    popUpTo<LoginDestination> { inclusive = true }
                }
            }
        }

        composable<HomeDestination> {
            HomeScreen(
                onTransactionsClick = {
                    navController.navigate(TransactionsDestination)
                }
            ) {
                navController.navigate(TransferDestination)
            }
        }

        composable<TransactionsDestination> {
            TransactionsScreen { navController.popBackStack() }
        }

        composable<TransferDestination> {
            TransferScreen(
                onTransferSuccess = { transactionId ->
                    navController.navigate(
                        ReceiptDestination(transactionId = transactionId)
                    )
                }
            ) { navController.popBackStack() }
        }

        composable<ReceiptDestination> { backStackEntry ->
            val destination = backStackEntry.toRoute<ReceiptDestination>()

            ReceiptScreen(
                transactionId = destination.transactionId
            ) {
                navController.navigate(HomeDestination){
                    popUpTo<HomeDestination> { inclusive = true }
                }
            }
        }
    }
}