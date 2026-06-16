package com.jotasedev.finwallet.core.design.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun AmountTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "Amount",
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    supportingText: String? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            val isValidInput = newValue.isEmpty() || newValue.matches(Regex("^\\d{0,7}(\\.\\d{0,2})?$"))

            if (isValidInput) onValueChange(newValue)
        },
        label = { Text(text = label) },
        prefix = { Text(text = "S/") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        ),
        singleLine = true,
        isError = isError,
        supportingText = {
            if (supportingText != null) Text(text = supportingText)
        },
        modifier = modifier.fillMaxWidth()
    )
}