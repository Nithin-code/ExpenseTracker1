package com.nithin.expensetracker_1.presentation.add_expense.viewModel

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.AnimationVector4D
import androidx.compose.animation.core.tween
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nithin.expensetracker_1.data.ExpanseTypeData
import com.nithin.expensetracker_1.domain.ExpensesTypeList
import com.nithin.expensetracker_1.presentation.add_expense.TransactionTypeHeaderData
import com.nithin.expensetracker_1.presentation.add_expense.stateManager.ScreenEvent
import com.nithin.expensetracker_1.presentation.add_expense.stateManager.ScreenState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class AddExpenseScreenViewModel : ViewModel() {

    private val clickListener = MutableSharedFlow<ScreenEvent>()

    private lateinit var mainCoroutineScope: CoroutineScope


    private val headerPosition = Animatable(
        initialValue = 0f,
    )

    private var bgColor : Animatable<Color, AnimationVector4D> = androidx.compose.animation.Animatable(
        initialValue = Color.Red.copy(alpha = 0.25f),
    )

    var screenState = mutableStateOf(
        ScreenState(
            bgColor = bgColor,
            headerOffSetPosition = headerPosition,
            selectedCategory = ExpensesTypeList.getItems[0],
            selectedDate = "15 Jul, 2025",
            transactionTypeHeaderData = TransactionTypeHeaderData(
                title = "Expense",
                offSet = Offset.Zero,
                size = IntSize.Zero
            )
        )
    )

    fun updateSizeAndOffSet(size: IntSize,offset: Offset){
        screenState.value = screenState.value.copy(
        )
    }

    fun onExpanseHeaderClicked(transactionTypeHeaderData: TransactionTypeHeaderData,scope: CoroutineScope){

        scope.launch {
            bgColor.animateTo(
                targetValue = if (transactionTypeHeaderData.title == "Expense") Color.Red.copy(alpha = 0.25f) else Color.Green.copy(alpha = 0.25f),
                animationSpec = tween(durationMillis = 800)
            )
        }

        screenState.value = screenState.value.copy(
            transactionTypeHeaderData = transactionTypeHeaderData,
            bgColor = bgColor
        )

    }

    fun showDatePicker(){
        screenState.value = screenState.value.copy(
            showDatePicker = true
        )



    }



    fun animateHeaderPosition(scope: CoroutineScope){
        scope.launch {
            headerPosition.animateTo(
                targetValue = screenState.value.transactionTypeHeaderData.offSet.x,
                animationSpec = tween(500)
            )
            screenState.value = screenState.value.copy(
                headerOffSetPosition = headerPosition
            )
        }
    }




}