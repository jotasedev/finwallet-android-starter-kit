package com.jotasedev.finwallet.core.navigation
import kotlinx.serialization.Serializable

@Serializable
data object LoginDestination

@Serializable
data object OtpDestination

@Serializable
data object HomeDestination

@Serializable
data object TransactionsDestination

@Serializable
data object TransferDestination

@Serializable
data class ReceiptDestination(
    val transactionId: String
)