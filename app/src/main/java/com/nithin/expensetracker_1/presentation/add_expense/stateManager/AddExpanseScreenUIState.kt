package com.nithin.expensetracker_1.presentation.add_expense.stateManager

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.AnimationVector4D
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.nithin.expensetracker_1.data.ExpanseTypeData
import com.nithin.expensetracker_1.domain.ExpensesTypeList
import com.nithin.expensetracker_1.presentation.add_expense.TransactionTypeHeaderData

data class ScreenState(
    val bgColor : Animatable<Color,AnimationVector4D>,
    val headerOffSetPosition : Animatable<Float, AnimationVector1D>,
    val selectedCategory: ExpanseTypeData,
    val selectedDate : String,
    val transactionTypeHeaderData : TransactionTypeHeaderData,
    val showDatePicker : Boolean = false,
    val showCategoryPicker : Boolean = false
)


//@Composable
//fun rememberAddExpenseUIState() : ScreenState{
//
//    return remember {
//        ScreenState(
//            bgColor = Color.Red.copy(alpha = 0.25f),
//            headerOffSetPosition = Offset(0f,0f),
//            selectedCategory = ExpensesTypeList.getItems[0],
//            selectedDate = "15 Jul, 2025",
//            transactionTypeHeaderData = TransactionTypeHeaderData()
//        )
//    }
//
//}