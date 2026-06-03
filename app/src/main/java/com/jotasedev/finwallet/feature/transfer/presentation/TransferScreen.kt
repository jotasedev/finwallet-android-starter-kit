package com.jotasedev.finwallet.feature.transfer.presentation

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
fun TransferScreen(
    onTransferSuccess: (String) -> Unit,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Transfer Screen")
        Button(onClick = { onTransferSuccess("TX-001") }) {
            Text(text = "Simulate Transfer")
        }
        Button(onClick = onBackClick) {
            Text(text = "Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransferScreenPreview(){
    TransferScreen(onTransferSuccess = {}) { }
}