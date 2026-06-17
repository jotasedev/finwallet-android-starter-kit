package com.jotasedev.finwallet.feature.receipt.presentation

data class ReceiptUiModel(
    val transactionId: String,
    val recipient: String,
    val amount: String,
    val description: String?,
    val date: String,
    val status: ReceiptStatus
)

enum class ReceiptStatus(
    val label: String
){
    SUCCESS("Successful"),
    PENDING("Pending"),
    FAILED("Failed")
}