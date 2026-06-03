package com.jotasedev.finwallet.feature.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jotasedev.finwallet.core.design.component.FinWalletButton
import com.jotasedev.finwallet.core.design.component.FinWalletScreenHeader
import com.jotasedev.finwallet.core.design.component.FinWalletTextField

@Composable
fun OtpScreen(
    onOtpSuccess: () -> Unit
) {
    var otp by remember { mutableStateOf("") }
    val isOtpValid = otp.length == 6

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        FinWalletScreenHeader(
            title = "Verify your identity",
            subtitle = "Enter the 6-digit code sent to your phone."
        )
        Spacer(modifier = Modifier.height(32.dp))
        FinWalletTextField(
            value = otp,
            onValueChange = { value ->
                if (value.length <= 6 && value.all { it.isDigit() }){
                    otp = value
                }
            },
            label = "Verification code",
            keyboardType = KeyboardType.Number,
            isError = otp.isNotEmpty() && !isOtpValid,
            supportingText = if (otp.isNotEmpty() && !isOtpValid){
                "OTP must have 6 digits"
            } else{
                null
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        FinWalletButton(
            text = "Verify",
            enabled = isOtpValid,
            onClick = onOtpSuccess
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "User any 6-digit code for this demo flow.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OtpScreenPreview(){
    OtpScreen {  }
}
