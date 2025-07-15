package com.nithin.expensetracker_1.presentation.components

import android.content.Context
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun SliderRow() {

    val items = remember {
        mutableStateListOf(
            SliderRowItemData(
                title = "Day"
            ),
            SliderRowItemData(
                title = "Week"
            ),
            SliderRowItemData(
                title = "Month"
            ),
        )
    }

    val itemsCount = items.size

    var selectedItem = remember {
        mutableIntStateOf(0)
    }

    var animateOffSet = animateOffsetAsState(
        targetValue = items[selectedItem.value].offset,
        animationSpec = tween(600)
    )


    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(50),
        color = Color.Blue.copy(alpha = 0.25f)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 20.dp)
        ) {

            Row {

                items.forEachIndexed { index, sliderRowItemData ->

                    Box(
                        modifier = Modifier
                            .clickable {
                                selectedItem.intValue = index
                            }
                            .onGloballyPositioned {
                                val offset = it.positionInParent()
                                items[index] = items[index].copy(
                                    offset = offset,
                                    size = it.size
                                )
                            }
                            .weight((1f / 3f)),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = sliderRowItemData.title,
                            fontSize = 16.sp
                        )
                    }

                }

            }

            Surface(
                modifier = Modifier
                    .offset {
                        IntOffset(
                            x = animateOffSet.value.x.toInt(),
                            y = animateOffSet.value.y.toInt()
                        )
                    }.width(
                        width = items[selectedItem.value].size.width.convertPxToDp(context).dp,
                    ).height((items[selectedItem.value].size.height).convertPxToDp(context).dp),
                color = Color.Transparent.copy(
                    alpha = 0.05f
                ),
                shape = RoundedCornerShape(55),
                tonalElevation = 5.dp
            ) {

            }

        }

    }


}

data class SliderRowItemData(
    val title : String,
    val offset: Offset = Offset.Zero,
    val size: IntSize = IntSize.Zero
)

fun Float.convertPxToDp(context: Context): Float {
    return this / context.resources.displayMetrics.density
}

fun Int.convertPxToDp(context: Context): Float {
    return this / context.resources.displayMetrics.density
}