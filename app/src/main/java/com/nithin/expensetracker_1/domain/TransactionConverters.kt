package com.nithin.expensetracker_1.domain

fun Double.toDisplayValue(isCredit : Boolean) : String {
    return if (isCredit) "+$this" else "-$this"
}


