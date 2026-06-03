package com.jotasedev.finwallet.feature.auth.presentation

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
fun OtpScreen(
    onOtpSuccess: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "OTP Screen")
        Button(onClick = onOtpSuccess) {
            Text(text = "Validate OTP")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OtpScreenPreview(){
    OtpScreen {  }
}
