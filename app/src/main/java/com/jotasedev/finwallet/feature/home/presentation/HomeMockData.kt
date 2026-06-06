package com.jotasedev.finwallet.feature.home.presentation

data class HomeTransactionUi (
    val title: String,
    val date: String,
    val amount: String
)

val homeMockTransactions = listOf(
    HomeTransactionUi(
        title = "Money received",
        date = "Today, 09:30",
        amount = "+ S/ 120.00"
    ),
    HomeTransactionUi(
        title = "Transfer sent",
        date = "Yesterday, 18:45",
        amount = "- S/ 80.00"
    ),
    HomeTransactionUi(
        title = "QR payment",
        date = "May 28, 14:10",
        amount = "- S/ 35.90"
    )
)