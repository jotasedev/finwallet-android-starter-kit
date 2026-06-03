package com.jotasedev.finwallet.feature.receipt.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ReceiptScreen(
    transactionId: String,
    onHomeClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Receipt Screen")
        Text(text = "Transaction ID: $transactionId")
        Button(onClick = onHomeClick) {
            Text(text = "Go Home")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReceiptScreenPreview(){
    ReceiptScreen(transactionId = "BAC-303") { }
}