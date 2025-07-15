package com.nithin.expensetracker_1.data

import android.graphics.drawable.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class ExpanseTypeData(
    val iconId : Int,
    val text : String,
    val iconTint : Color = Color.Black
)