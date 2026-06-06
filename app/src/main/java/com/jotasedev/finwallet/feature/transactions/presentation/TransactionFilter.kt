package com.jotasedev.finwallet.feature.transactions.presentation

enum class TransactionFilter(
    val label: String
) {
    ALL(label = "All"),
    INCOME (label = "Income"),
    EXPENSES(label = "Expenses")
}