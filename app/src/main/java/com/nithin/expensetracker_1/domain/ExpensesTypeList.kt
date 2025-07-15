package com.nithin.expensetracker_1.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.nithin.expensetracker_1.R
import com.nithin.expensetracker_1.data.ExpanseTypeData
import com.nithin.expensetracker_1.presentation.theme.expenseColor
import com.nithin.expensetracker_1.presentation.theme.personColor

object ExpensesTypeList {

    val getItems = listOf(
        ExpanseTypeData(
            iconId = R.drawable.fast_food,
            text = "Food",
            iconTint = Color.Blue,
        ),
        ExpanseTypeData(
            iconId = R.drawable.man,
            text = "To Person",
            iconTint = personColor,
        ),
        ExpanseTypeData(
            iconId = R.drawable.fast_food,
            text = "Subscription",
            iconTint = Color.Green,
        ),
        ExpanseTypeData(
            iconId = R.drawable.fast_food,
            text = "Subscription",
            iconTint = Color.Green,
        ),
    )

}