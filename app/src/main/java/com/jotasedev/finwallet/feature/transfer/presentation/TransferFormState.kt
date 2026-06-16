package com.jotasedev.finwallet.feature.transfer.presentation

import android.os.IBinder

data class TransferFormState(
    val recipient: String = "",
    val amount: String = "",
    val description: String = ""
) {
    val isRecipientValid: Boolean
        get() = recipient.trim().length >= 3

    val amountValue: Double
        get() = amount.toDoubleOrNull() ?: 0.0

    val isAmountValid: Boolean
        get() = amountValue > 0.0

    val isFormValid: Boolean
        get() = isRecipientValid && isAmountValid
}