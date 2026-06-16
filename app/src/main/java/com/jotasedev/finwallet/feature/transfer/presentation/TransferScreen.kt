package com.jotasedev.finwallet.feature.transfer.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jotasedev.finwallet.core.design.component.AmountTextField
import com.jotasedev.finwallet.core.design.component.ConfirmationCard
import com.jotasedev.finwallet.core.design.component.FinWalletButton
import com.jotasedev.finwallet.core.design.component.FinWalletScreenHeader
import com.jotasedev.finwallet.core.design.component.FinWalletTextField

@Composable
fun TransferScreen(
    onTransferSuccess: (String) -> Unit,
    onBackClick: () -> Unit
) {
    var formState by remember {
        mutableStateOf(TransferFormState())
    }

    val showRecipientError = formState.recipient.isNotBlank() && !formState.isRecipientValid
    val showAmountError = formState.amount.isNotBlank() && !formState.isAmountValid

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.Top
    ) {
        TextButton(onClick = onBackClick) { Text(text = "Back") }
        Spacer(modifier = Modifier.height(16.dp))
        FinWalletScreenHeader(
            title = "Send money",
            subtitle = "Enter the recipient and amount to simulate a secure transfer"
        )
        Spacer(modifier = Modifier.height(32.dp))
        FinWalletTextField(
            value = formState.recipient,
            onValueChange = { value ->
                formState = formState.copy(recipient = value)
            },
            label = "Recipient",
            isError = showRecipientError,
            supportingText = if (showRecipientError) {
                "Recipient must have at least 3 characters"
            } else {
                null
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        AmountTextField(
            value = formState.amount,
            onValueChange = { value ->
                formState = formState.copy(amount = value)
            },
            isError = showAmountError,
            supportingText = if (showAmountError) {
                "Amount must be greater than zero"
            } else {
                null
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        FinWalletTextField(
            value = formState.description,
            onValueChange = { value ->
                if (value.length <= 40) formState = formState.copy(description = value)
            },
            label = "Description optional",
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(24.dp))
        if (formState.isFormValid) {
            ConfirmationCard(
                recipient = formState.recipient,
                amount = formState.amount,
                description = formState.description
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        FinWalletButton(
            text = "Confirm Transfer",
            enabled = formState.isFormValid,
            onClick = {
                onTransferSuccess("TX-${System.currentTimeMillis()}")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "This demo does not perform real financial operation.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TransferScreenPreview() {
    TransferScreen(onTransferSuccess = {}) { }
}