package com.nithin.expensetracker_1.presentation.components

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nithin.expensetracker_1.data.DashBoardCardDetails
import com.nithin.expensetracker_1.data.PIData
import com.nithin.expensetracker_1.data.TransactionDetails
import com.nithin.expensetracker_1.data.toFloatSize
import com.nithin.expensetracker_1.domain.toDisplayValue
import com.nithin.expensetracker_1.presentation.homescreen.items
import com.nithin.expensetracker_1.presentation.theme.BackgroundWhite
import com.nithin.expensetracker_1.presentation.theme.cardBackground
import com.nithin.expensetracker_1.presentation.theme.cardPurple
import com.nithin.expensetracker_1.presentation.theme.expenseColor
import com.nithin.expensetracker_1.presentation.theme.incomeColor
import com.nithin.expensetracker_1.presentation.theme.lightGray

@Composable
fun DashBoardComponent(
    modifier: Modifier = Modifier
) {

    val localConfig = LocalConfiguration.current
    val screenWidthDp = localConfig.screenWidthDp

    val boxWidth = (screenWidthDp).dp

    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

    val items =  remember {
        mutableStateListOf(
            DashBoardCardDetails(
                title = "Day",
            ),
            DashBoardCardDetails(
                title = "Week",
            ),
            DashBoardCardDetails(
                title = "Month",
            ),
        )
    }
    var animateOffSetPosition = animateOffsetAsState(
        targetValue = items[selectedItemIndex].offset,
        animationSpec = tween(durationMillis = 800)
    )

    Surface(
        color = cardBackground,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .width(boxWidth)
            .padding(start = 20.dp, end = 20.dp),
        shadowElevation = 5.dp
    ) {

        Column(
            modifier = Modifier
                .width(boxWidth)
                .height(150.dp)
                .padding(start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(
                text = "$1,720",
                color = BackgroundWhite,
                fontSize = 24.sp
            )

            SliderRow()


//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//            ) {
//
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                ) {
//
//                    items.forEachIndexed{ index, dashBoardCardDetails ->
//
//                        Text(
//                            text = dashBoardCardDetails.title,
//                            modifier = Modifier
//                                .clickable {
//                                    selectedItemIndex = index
//                                }
//                                .onGloballyPositioned {
//                                    val pos = it.positionInParent()
//                                    items[index] = items[index].copy(
//                                        offset = pos,
//                                        size = it.size
//                                    )
//                                }
//                                .weight((1f / items.count()).toFloat()),
//                            textAlign = TextAlign.Center
//                        )
//
//
//                    }
//
//                }
//
//                Canvas(
//                    modifier = Modifier
//                ) {
//
//                    drawRoundRect(
//                        color = Color.White,
//                        topLeft = animateOffSetPosition.value,
//                        size = items[selectedItemIndex].size.toFloatSize(),
//                        cornerRadius = CornerRadius(x = 20f, y = 20f),
//                        style = Stroke(
//                            width = 2f
//                        )
//                    )
//
////                    drawLine(
////                        color = cardBackground.copy(alpha = 0.25f),
////                        start = items[selectedItemIndex].offset,
////                        end = items[selectedItemIndex+1].offset,
////                        strokeWidth = 2f
////                    )
//
//                }
//
//            }

        }

    }

}



@Composable
fun PiChatCard(
    modifier: Modifier = Modifier
) {

    val localConfig = LocalConfiguration.current
    val screenWidthDp = localConfig.screenWidthDp
    val radius = screenWidthDp/4

    val colors = listOf(
        Color.Red,
        Color.Green,
        Color.Blue,
        Color.Yellow,
        Color.Magenta,
        Color.Cyan
    )

    Surface(
        modifier = modifier.padding(horizontal = 20.dp),
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 5.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height((screenWidthDp / 2.5).dp)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Canvas(
                modifier = Modifier
                    .size(
                        width = (screenWidthDp/3).dp,
                        height = (screenWidthDp/3).dp
                    )
            ) {

                val sweepAngle = 360f/colors.size
                var startAngle = 0f


                colors.forEach{color->

                    drawArc(
                        color = color,
                        startAngle = startAngle,
                        sweepAngle = sweepAngle,
                        topLeft = Offset(0f,0f),
                        size = this.size,
                        useCenter = false,
                        style = Stroke(width = 60f)
                    )

                    startAngle+=sweepAngle

                }


            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {


                ExpensePIDetails(
                    title = "Food"
                )

                ExpensePIDetails(
                    title = "Shopping",
                    color = Color.Blue
                )

                ExpensePIDetails(
                    title = "Travel",
                    color = Color.Green
                )



            }

        }

    }


}

@Preview(showBackground = true)
@Composable
fun TransactionDetailsListCard(
    modifier: Modifier = Modifier,
    date : String = "July 08, 2025",
    itemsList : List<TransactionDetails> = items
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        Text(
            text = date,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        itemsList.forEach {

            TransactionDetailsCardUI(
                transactionDetails = it
            )

        }


    }
    


}

@Preview
@Composable
fun TransactionDetailsCardUI(
    transactionDetails: TransactionDetails = items[0]
){

    Spacer(modifier = Modifier.height(10.dp))

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 5.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Surface(
                modifier = Modifier,
                color = lightGray,
                shape = RoundedCornerShape(20.dp)
            ) {

                Box(
                    modifier = Modifier
                        .size(50.dp),
                    contentAlignment = Alignment.Center
                ){

                    Icon(
                        imageVector = transactionDetails.icon,
                        contentDescription = "",
                        tint = cardPurple
                    )

                }

            }

            Spacer(modifier = Modifier.width(25.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = transactionDetails.transactionMadeAt
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Clothing",
                    color = Color.Gray
                )
            }

            Column(modifier = Modifier) {
                Text(
                    text = transactionDetails.transactionAmount.toDisplayValue(transactionDetails.transactionType.isCredit),
                    color = transactionDetails.transactionType.indicatorColor
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Debited",
                    color = Color.Gray
                )
            }


        }

    }

}


@Composable
fun ExpensePIDetails(
    modifier: Modifier = Modifier,
    color: Color = Color.Red,
    title : String = ""
) {

    Spacer(modifier = Modifier.height(10.dp))

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Surface(
            modifier = Modifier
                .size(20.dp),
            shape = CircleShape,
            color = color
        ) {

        }

        Spacer(modifier = Modifier.width(15.dp))

        Text(
            text = title,
            fontSize = 18.sp
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun Pre() {
    Scaffold {padd->
        DashBoardComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padd)
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewPi() {
    PiChatCard()
}