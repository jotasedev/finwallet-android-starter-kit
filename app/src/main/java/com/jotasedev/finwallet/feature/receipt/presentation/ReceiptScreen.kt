package com.jotasedev.finwallet.feature.receipt.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jotasedev.finwallet.core.design.component.FinWalletButton
import com.jotasedev.finwallet.core.design.component.ReceiptDetailRow

@Composable
fun ReceiptScreen(
    transactionId: String,
    onHomeClick: () -> Unit
) {
    val receipt = ReceiptUiModel(
        transactionId = transactionId,
        recipient = "Demo recipient",
        amount = "S/ 150.00",
        description = "Demo transfer",
        date = "June 16, 2026 - 13:30",
        status = ReceiptStatus.SUCCESS
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = receipt.status.label,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = receipt.amount,
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(24.dp))
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ReceiptDetailRow(
                    label = "Recipient",
                    value = receipt.recipient
                )
                ReceiptDetailRow(
                    label = "Date",
                    value = receipt.date
                )
                ReceiptDetailRow(
                    label = "Operation ID",
                    value = receipt.transactionId
                )

                receipt.description?.takeIf { it.isNotBlank() }?.let {
                    ReceiptDetailRow(
                        label = "Description",
                        value = it
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        FinWalletButton(
            text = "Back to home",
            onClick = onHomeClick
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            onClick = {}
        ) {
            Text(text = "Share receipt")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReceiptScreenPreview(){
    ReceiptScreen(transactionId = "BAC-303") { }
}