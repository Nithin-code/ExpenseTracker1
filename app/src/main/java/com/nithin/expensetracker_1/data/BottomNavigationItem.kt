package com.nithin.expensetracker_1.data

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.IntSize

data class BottomNavigationItem(
    val title : String,
    val offset: Offset = Offset(0f,0f),
    val size : IntSize = IntSize.Zero,
    val icon : ImageVector
)
