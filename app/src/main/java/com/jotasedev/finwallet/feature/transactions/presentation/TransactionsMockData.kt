package com.jotasedev.finwallet.feature.transactions.presentation

val transactionsMockData = listOf(
    TransactionUi(
        id = "TX-0001",
        title = "Money received",
        description = "Transfer from Carlos Mendoza",
        date = "Today, 09:30",
        amount = "+ S/ 120.00",
        type = TransactionType.INCOME
    ),
    TransactionUi(
        id = "TX-0002",
        title = "Transfer sent",
        description = "Transfer to Ana Torres",
        date = "Yesterday, 18:45",
        amount = "- S/ 80.00",
        type = TransactionType.EXPENSE
    ),
    TransactionUi(
        id = "TX-0003",
        title = "QR payment",
        description = "Payment at Coffee Store",
        date = "May 28, 14:10",
        amount = "- S/ 35.90",
        type = TransactionType.EXPENSE
    ),
    TransactionUi(
        id = "TX-0004",
        title = "Top up",
        description = "Wallet recharge",
        date = "May 27, 11:20",
        amount = "+ S/ 250.00",
        type = TransactionType.INCOME
    ),
    TransactionUi(
        id = "TX-0005",
        title = "Service payment",
        description = "Mobile plan payment",
        date = "May 26, 20:05",
        amount = "- S/ 49.90",
        type = TransactionType.EXPENSE
    )
)