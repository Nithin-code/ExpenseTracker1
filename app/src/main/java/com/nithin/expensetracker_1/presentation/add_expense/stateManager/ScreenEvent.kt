package com.nithin.expensetracker_1.presentation.add_expense.stateManager

import com.nithin.expensetracker_1.data.ExpanseTypeData

sealed class ScreenEvent {

    data class ExpanseHeaderListener(val selectedType : String) : ScreenEvent()

    data class CategoryListener(val expenseTypeData : ExpanseTypeData) : ScreenEvent()

}