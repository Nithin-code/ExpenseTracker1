package com.nithin.expensetracker_1.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class TransactionDetails(
    val icon: ImageVector,
    val transactionMadeAt: String,
    val transactionAmount: Double,
    val transactionDate: String,
    val transactionType: TransactionType
)


data class TransactionType(
    val isCredit : Boolean = false,
){
    val indicatorColor : Color = if (isCredit) Color.Green else Color.Red
}

