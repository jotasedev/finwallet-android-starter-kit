package com.jotasedev.finwallet.feature.transactions.presentation


enum class TransactionType {
    INCOME,
    EXPENSE
}

data class TransactionUi(
    val id: String,
    val title: String,
    val description: String,
    val date: String,
    val amount: String,
    val type: TransactionType
) {
}