package com.nithin.expensetracker_1.presentation.dashboardviewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.lifecycle.ViewModel
import com.nithin.expensetracker_1.data.TransactionDetails
import com.nithin.expensetracker_1.data.TransactionType

class DashBoardViewModel : ViewModel() {

    val map : MutableMap<String, MutableList<TransactionDetails>> = mutableMapOf()

    val items = listOf(
        TransactionDetails(
            icon = Icons.Default.ShoppingCart,
            transactionMadeAt = "Nike Store",
            transactionAmount = 1024.00,
            transactionDate = "04 July",
            transactionType = TransactionType(
                isCredit = false
            )
        ),
        TransactionDetails(
            icon = Icons.Default.ShoppingCart,
            transactionMadeAt = "Nike Store",
            transactionAmount = 1024.00,
            transactionDate = "03 July",
            transactionType = TransactionType(
                isCredit = true
            )
        ),
        TransactionDetails(
            icon = Icons.Default.ShoppingCart,
            transactionMadeAt = "Nike Store",
            transactionAmount = 1024.00,
            transactionDate = "02 July",
            transactionType = TransactionType(
                isCredit = false
            )
        ),
        TransactionDetails(
            icon = Icons.Default.ShoppingCart,
            transactionMadeAt = "Nike Store",
            transactionAmount = 1024.00,
            transactionDate = "01 July",
            transactionType = TransactionType(
                isCredit = true
            )
        ),

        TransactionDetails(
            icon = Icons.Default.ShoppingCart,
            transactionMadeAt = "Nike Store",
            transactionAmount = 1024.00,
            transactionDate = "04 July",
            transactionType = TransactionType(
                isCredit = true
            )
        ),
    )

    fun getUIData() {

        items.forEach { item->

            val entries = map[item.transactionDate]
            if (entries == null){
                map.put(item.transactionDate,mutableListOf(item))
            }else{
                entries.add(item)
                map.put(item.transactionDate,entries)
            }

        }

        println(map.toString())

    }

}

