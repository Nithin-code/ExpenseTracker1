package com.nithin.expensetracker_1.presentation.navigation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.nithin.expensetracker_1.data.BottomNavigationItem
import com.nithin.expensetracker_1.presentation.components.convertPxToDp
import com.nithin.expensetracker_1.presentation.theme.cardBackground

@Composable
fun MyBottomNavigationBar(
    modifier: Modifier = Modifier,
    onMenuItemClick : (Int) -> Unit,
) {

    var selectedItem by remember {
        mutableStateOf(0)
    }

    val bottomSheetItems = remember {
        mutableStateListOf(
            BottomNavigationItem(
                title = "Home",
                icon = Icons.Default.Home
            ),
            BottomNavigationItem(
                title = "Add",
                icon = Icons.Default.Add
            ),
            BottomNavigationItem(
                title = "Profile",
                icon = Icons.Default.Person
            ),
        )
    }

    val animateXPosition = animateFloatAsState(
        targetValue = bottomSheetItems[selectedItem].offset.x,
        animationSpec = tween(durationMillis = 800)
    )


    val context = LocalContext.current

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 5.dp,
        border = BorderStroke(width = 1.dp, color = Color.LightGray.copy(alpha = 0.25f))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.Center
        ){

            Surface(
                modifier = Modifier
                    .offset {
                        IntOffset(
                            x = animateXPosition.value.toInt(),
                            y = bottomSheetItems[selectedItem].offset.y.toInt()
                        )
                    }
                    .height(5.dp)
                    .width(
                        bottomSheetItems[0]
                            .size.width
                            .convertPxToDp(context).dp
                    ),
                color = cardBackground,
                shape = RoundedCornerShape(99)
            ) {

            }

            Spacer(modifier = Modifier.height(5.dp))

            Row {

                bottomSheetItems.forEachIndexed { index, item ->

                    Box(
                        modifier = Modifier
                            .clickable {
                                selectedItem = index
                                onMenuItemClick.invoke(index)
                            }
                            .weight((1/bottomSheetItems.count().toFloat()))
                            .onGloballyPositioned {
                                val offset = it.positionInParent()
                                val size = it.size
                                bottomSheetItems[index] = bottomSheetItems[index]
                                    .copy(
                                        size = size,
                                        offset = offset
                                    )
                            },
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )

                    }

                }


            }


        }

    }

}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        MyBottomNavigationBar(
            onMenuItemClick = {

            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        )
    }
}