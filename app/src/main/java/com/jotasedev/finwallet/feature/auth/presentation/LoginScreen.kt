package com.jotasedev.finwallet.feature.auth.presentation

import android.widget.Space
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
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {

    var phoneNumber by remember { mutableStateOf("") }
    val isPhoneValid = phoneNumber.length == 9

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        FinWalletScreenHeader(
            title = "Welcome to FinWallet",
            subtitle = "Enter your phone number to continue securely."
        )
        Spacer(modifier = Modifier.height(32.dp))
        FinWalletTextField(
            value = phoneNumber,
            onValueChange = { value ->
                if (value.length <= 9 && value.all { it.isDigit() }){
                    phoneNumber = value
                }
            },
            label = "Phone number",
            keyboardType = KeyboardType.Number,
            isError = phoneNumber.isNotEmpty() && !isPhoneValid,
            supportingText = if (phoneNumber.isNotEmpty() && !isPhoneValid){
                "Phone number must have 9 digits"
            } else {
                null
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        FinWalletButton(
            text = "Continue",
            enabled = isPhoneValid,
            onClick = onLoginSuccess
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "This is demo app for secure transactional Android flows.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(onLoginSuccess = {})
}