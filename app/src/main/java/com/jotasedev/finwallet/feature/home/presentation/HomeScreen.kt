package com.jotasedev.finwallet.feature.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jotasedev.finwallet.core.design.component.BalanceCard
import com.jotasedev.finwallet.core.design.component.QuickActionCard
import com.jotasedev.finwallet.core.design.component.TransactionListItem

@Composable
fun HomeScreen(
    onTransactionsClick: () -> Unit,
    onTransferClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {
        Text(
            text = "Hi, Juan",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Welcome back to FinWallet",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        BalanceCard(
            balance = "S/ 2,540.80"
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Quick actions",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            QuickActionCard(
                title = "Transfer",
                description = "Send money",
                onClick = onTransferClick,
                modifier = Modifier.weight(1f)
            )

            QuickActionCard(
                title = "History",
                description = "View activity",
                onClick = onTransactionsClick,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Recent transactions",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        homeMockTransactions.forEach { transaction ->
            TransactionListItem(
                title = transaction.title,
                date = transaction.date,
                amount = transaction.amount
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(onTransactionsClick = {}) { }
}