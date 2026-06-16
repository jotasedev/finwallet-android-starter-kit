package com.jotasedev.finwallet.core.design.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConfirmationCard(
    recipient: String,
    amount: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Transfer summary",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Recipient: $recipient",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Amount: S/ $amount",
                style = MaterialTheme.typography.bodyMedium
            )

            if (description.isNotBlank()){
                Text(
                    text = "Description: $description",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}