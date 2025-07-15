package com.nithin.expensetracker_1.presentation.add_expense

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.viewModelFactory
import com.nithin.expensetracker_1.data.ExpanseTypeData
import com.nithin.expensetracker_1.domain.ExpensesTypeList
import com.nithin.expensetracker_1.presentation.add_expense.stateManager.ScreenState
import com.nithin.expensetracker_1.presentation.add_expense.viewModel.AddExpenseScreenViewModel
import com.nithin.expensetracker_1.presentation.components.convertPxToDp
import com.nithin.expensetracker_1.presentation.theme.cardBackground
import com.nithin.expensetracker_1.presentation.theme.textLightColor
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun AddExpenseScreen(
    modifier: Modifier = Modifier,
    viewModel: AddExpenseScreenViewModel
) {



    var expenseType by remember {
        mutableStateOf("Expense")
    }


    Box(
        modifier = modifier
            .background(color = viewModel.screenState.value.bgColor.value)
    ){

        Surface(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 20.dp),
            shadowElevation = 5.dp,
            shape = RoundedCornerShape(20.dp),
            color = Color.White
        ) {

            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Add Transaction",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier
                    .height(40.dp)
                )

                AddExpenseScreenCard(
                    screenViewModel = viewModel,
                    onExpansetypeChanged = {type->
                        expenseType = type
                    }
                )

                CategoryType()

                DateInfo()

                Spacer(modifier = Modifier.height(20.dp))

                IosButton(
                    onClick = {

                    }
                )

            }

        }

    }





}

@Composable
fun CategoryType(
    modifier: Modifier = Modifier,
    items : List<ExpanseTypeData> = ExpensesTypeList.getItems
) {

    Spacer(
        modifier = Modifier
            .height(10.dp)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),

    ) {

        Text(
            text = "Category",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Surface(
            color = Color.LightGray
                .copy(alpha = 0.25f),
            shape = RoundedCornerShape(15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(
                        id = items[0].iconId,

                    ),
                    tint = Color.Unspecified,
                    contentDescription = "shopping_icon",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = items[0].text,
                    modifier = Modifier.weight(1f),
                    fontSize = 16.sp
                )

                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "dropdown_icon"
                )

            }
        }

    }


}

@Composable
fun DateInfo(
    modifier: Modifier = Modifier,
    currentDate : Date = Date(System.currentTimeMillis())
) {

    var selectedDate by remember {
        mutableStateOf(currentDate.toReadableString())
    }

    Spacer(
        modifier = Modifier
            .height(10.dp)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),

        ) {

        Text(
            text = "Date",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Surface(
            color = Color.LightGray
                .copy(alpha = 0.25f),
            shape = RoundedCornerShape(15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "date icon"
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "Date",
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = selectedDate,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp),
                    textAlign = TextAlign.End,
                )

            }
        }

    }


}

@Composable
fun IosButton(
    modifier: Modifier = Modifier,
    onClick : () -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        color = cardBackground.copy(alpha = 0.85f),
        onClick = onClick
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Save",
                color = Color.White
            )
        }

    }

}

@Composable
fun AddExpenseScreenCard(
    modifier: Modifier = Modifier,
    screenViewModel: AddExpenseScreenViewModel,
    onExpansetypeChanged : (String) -> Unit
) {



    var inputAmount by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
    ) {

        TransactionTypeHeader(
            screenViewModel = screenViewModel,
            onExpenseTypeChanged = {type->
                onExpansetypeChanged.invoke(type)
            }

        )

        Spacer(
            modifier = Modifier
            .height(10.dp)
        )

        TextField(
            value = inputAmount,
            onValueChange = {
                inputAmount = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.CheckCircle,
                    contentDescription = "Amount Icon"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp)),
            colors = TextFieldDefaults
                .colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                )
        )

    }



}


@Composable
private fun TransactionTypeHeader(
    screenViewModel: AddExpenseScreenViewModel,
    onExpenseTypeChanged : (String) -> Unit
) {

    val scope = rememberCoroutineScope()


    val items = remember {
        mutableStateListOf(
            TransactionTypeHeaderData(
                title = "Expense",
                offSet = Offset.Zero,
                size = IntSize.Zero
            ),
            TransactionTypeHeaderData(
                title = "Income",
                offSet = Offset.Zero,
                size = IntSize.Zero
            ),
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {

            items.forEachIndexed{ index,item->

                Text(
                    modifier = Modifier
                        .weight(1 / items.size.toFloat())
                        .onGloballyPositioned {
                            val offSet = it.positionInParent()
                            items[index] = items[index].copy(
                                offSet = offSet,
                                size = it.size
                            )
                        }
                        .clickable {
                            screenViewModel.onExpanseHeaderClicked(transactionTypeHeaderData = items[index] , scope)
                            screenViewModel.animateHeaderPosition(scope)
                        }
                        .padding(5.dp, bottom = 10.dp)
                    ,
                    text = item.title,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = if (item.title == screenViewModel.screenState.value.transactionTypeHeaderData.title) cardBackground else Color.Black
                )

            }

        }

        Box {
            HorizontalDivider(
                thickness = 2.dp,
                color = Color.LightGray
            )

            Surface(
                modifier = Modifier
                    .width(items[0].size.width.convertPxToDp(LocalContext.current).dp)
                    .height(2.dp)
                    .offset {
                        IntOffset(
                            x = screenViewModel.screenState.value.headerOffSetPosition.value.toInt(),
                            y = screenViewModel.screenState.value.transactionTypeHeaderData.offSet.y.toInt()
                        )
                    },
                color = cardBackground,
                content = {}
            )


        }

        

    }

}

@Preview(showBackground = true)
@Composable
private fun Prec() {
    val viewModel = AddExpenseScreenViewModel()
    Scaffold { padd->
        AddExpenseScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(padd),
            viewModel
        )
    }
}


data class TransactionTypeHeaderData(
    val title : String,
    val offSet : Offset,
    val size : IntSize
)

fun Date.toReadableString() : String {
    val simpleDateConverter = SimpleDateFormat("dd MMM, YYYY")
    return simpleDateConverter.format(this)

}