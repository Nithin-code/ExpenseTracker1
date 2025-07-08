package com.nithin.expensetracker_1.data

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.IntSize

data class DashBoardCardDetails(
    val title : String,
    val offset: Offset = Offset.Zero,
    val size: IntSize = IntSize.Zero
)

fun IntSize.toFloatSize() : Size{
    return Size(
        width = this.width.toFloat(),
        height = this.height.toFloat()
    )
}