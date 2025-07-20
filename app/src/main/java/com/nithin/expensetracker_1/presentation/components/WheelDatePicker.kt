package com.nithin.expensetracker_1.presentation.components

import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nithin.expensetracker_1.data.DateData
import com.nithin.expensetracker_1.data.ExpanseTypeData
import com.nithin.expensetracker_1.domain.ExpensesTypeList
import com.nithin.expensetracker_1.presentation.theme.cardBackground
import kotlinx.coroutines.delay


@Composable
fun WheelDatePicker(
    modifier: Modifier = Modifier,
    shouldShow : Boolean = false
) {

    DateData.createData()

    val scrollState = rememberScrollState()
    
    LaunchedEffect(Unit) {

        delay(2000L)
        scrollState.animateScrollTo(
            value = 500,
            tween(durationMillis = 1000)
        )

    }

    val animateOffSet = animateOffsetAsState(
        targetValue = if (shouldShow) Offset(0f,0f) else Offset(0f, 600f),
        animationSpec = tween(durationMillis = 800)
    )

    Surface(
        modifier = modifier
            .offset {
                IntOffset(
                    x = animateOffSet.value.x.toInt(),
                    y = animateOffSet.value.y.toInt()
                )
            }
            .padding(horizontal = 20.dp),
        shadowElevation = 5.dp,
        shape = RoundedCornerShape(10.dp),
        color = Color.White,
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(10.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Select Date",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Done",
                    color = cardBackground,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .clickable {

                        }
                )

            }

            Spacer(modifier = Modifier.height(10.dp))

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Column(
                        modifier = Modifier
                            .verticalScroll(state = scrollState)
                    ) {

                        DateData.days.forEach {

                            Text(
                                text = "$it"
                            )

                            Spacer(
                                modifier = Modifier.height(10.dp)
                            )


                        }

                    }

                    Column(
                        modifier = Modifier.verticalScroll(state = scrollState)
                    ) {

                        DateData.months.forEach {

                            Text(
                                text = it
                            )

                            Spacer(
                                modifier = Modifier.height(10.dp)
                            )

                        }

                    }

                    Column(
                        modifier = Modifier.verticalScroll(state = scrollState)
                    ) {

                        DateData.years.forEach {

                            Text(
                                text = "$it"
                            )

                            Spacer(
                                modifier = Modifier.height(10.dp)
                            )

                        }

                    }

                }

                Surface(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .height(30.dp)
                        .fillMaxWidth(),
                    color = Color.Transparent,
                    border = BorderStroke(width = 1.dp, color = cardBackground),
                    shape = RoundedCornerShape(10.dp)
                ) {

                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ExpensesTypeList.getItems.forEachIndexed { index, expanseTypeData ->

                    Row(
                        modifier = Modifier
                            .clickable {

                            }
                            .fillMaxWidth(),

                    ) {

                        Icon(
                            painter = painterResource(id = expanseTypeData.iconId),
                            tint = Color.Unspecified,
                            contentDescription = "shopping_icon",
                            modifier = Modifier.size(24.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = expanseTypeData.text,
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

    }

}


@Composable
fun WheelCategoryPicker(
    modifier: Modifier = Modifier,
    shouldShow : Boolean = false,
    onItemClicked : (ExpanseTypeData) -> Unit,
    onDoneButtonClicked : () -> Unit
) {

    val scrollState = rememberScrollState()

    val animateOffSet = animateOffsetAsState(
        targetValue = if (shouldShow) Offset(0f,0f) else Offset(0f, 600f),
        animationSpec = tween(durationMillis = 800)
    )



    
    Surface(
        modifier = modifier
            .offset {
                IntOffset(
                    x = animateOffSet.value.x.toInt(),
                    y = animateOffSet.value.y.toInt()
                )
            }
            .padding(horizontal = 20.dp),
        shadowElevation = 5.dp,
        shape = RoundedCornerShape(10.dp),
        color = Color.White,
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Select a category",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Done",
                    color = cardBackground,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .clickable {
                            onDoneButtonClicked()
                        }
                )

            }

            Spacer(modifier = Modifier.height(10.dp))

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(state = scrollState)
            ) {
                ExpensesTypeList.getItems.forEachIndexed { index, expanseTypeData ->

                    Row(
                        modifier = Modifier
                            .clickable {
                                onItemClicked.invoke(expanseTypeData)
                            }
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(id = expanseTypeData.iconId),
                            tint = Color.Unspecified,
                            contentDescription = "shopping_icon",
                            modifier = Modifier.size(24.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = expanseTypeData.text,
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

    }

}

@Preview
@Composable
private fun PreviewWheelPicker() {

    Scaffold() { padd->
        WheelCategoryPicker(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(padd),
            onItemClicked = {

            },
            onDoneButtonClicked = {

            }
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewDatePicker() {

    Scaffold() { padd->
        WheelDatePicker(
            modifier = Modifier.fillMaxWidth().padding(padd)
        )
    }

}